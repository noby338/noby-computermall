package com.woniuxy.salesmanage.service.impl;

import com.woniuxy.commonentity.entity.*;
import com.woniuxy.salesmanage.dao.SaleOrderDao;
import com.woniuxy.salesmanage.openFeign.CooperationFeign;
import com.woniuxy.salesmanage.openFeign.StorehouseFeign;
import com.woniuxy.salesmanage.service.*;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 出售订单(SaleOrder)表服务实现类
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@Service("saleOrderService")
@Slf4j
public class SaleOrderServiceImpl implements SaleOrderService {
    @Resource
    private SaleOrderDao saleOrderDao;

    @Resource
    private ClientService clientService;

    @Resource
    private ClientAddressService clientAddressService;

    @Resource
    private SaleCartService saleCartService;

    @Resource
    private SaleRecordService saleRecordService;

    @Resource
    private SaleCartOrderItemService saleCartOrderItemService;

    @Resource
    private CooperationFeign cooperationFeign;

    @Resource
    private StorehouseFeign storehouseFeign;

    /**
     * 下单
     *
     * @param clientId
     * @return
     */
    @Override
//    @GlobalTransactional(name = "placeOrderTransactional",rollbackFor = Exception.class)
    @GlobalTransactional
    public SaleOrder placeOrder(int clientId) {
        //查询到该商户id的商户
        SaleOrder saleOrder = new SaleOrder();
        Client client = clientService.queryById(clientId);
        if (client == null) {
            log.error("该用户不存在");
            throw new RuntimeException("该用户不存在");
        }

        //设置订单的商户信息
        saleOrder.setPhoneNum(client.getPhoneNum());
        ClientAddress clientAddress1 = new ClientAddress();
        clientAddress1.setClientId(clientId);
        List<ClientAddress> clientAddressList = clientAddressService.queryByEntity(clientAddress1);
        for (ClientAddress clientAddress : clientAddressList) {
            if (clientAddress.getIsDefault() == 1) {
                saleOrder.setAddress(clientAddress.getAddress());
            }
        }
        SaleCart saleCart = saleCartService.queryById(client.getSaleCart().getId());
        saleOrder.setTotalPrice(saleCart.getTotalPrice());
        saleOrder.setStatus(1);
        saleOrder.setClientId(clientId);
        SaleOrder insertSaleOrder = null;
        try {
            insertSaleOrder = insert(saleOrder);
        } catch (Exception e) {
            log.error("添加订单失败", e);
            throw new RuntimeException("添加订单失败",e);
        }
        log.info("添加订单成功");

        //添加订单记录
        SaleRecord saleRecord = new SaleRecord(null, new Date(), saleOrder.getId(), 1, saleOrder);
        try {
            saleRecordService.insert(saleRecord);
        } catch (Exception e) {
            log.error("添加订单记录失败", e);
            throw new RuntimeException("添加订单记录失败",e);
        }
        log.info("添加订单记录成功");


        List<SaleCartOrderItem> saleCartOrderItemList = saleCart.getSaleCartOrderItemList();
        for (SaleCartOrderItem saleCartOrderItem : saleCartOrderItemList) {
            //将购物车订单条目中的订单外键指向该订单，并将购物车订单条目中的购物车外键置空
            saleCartOrderItem.setSaleOrderId(saleOrder.getId());
            saleCartOrderItem.setSaleCartId(null);
            try {

                saleCartOrderItemService.update(saleCartOrderItem);
            } catch (Exception e) {
                log.error("更新订单条目失败", e);
                throw new RuntimeException("更新订单条目失败",e);
            }

            //cooperationFeign修改model剩余数量
            Model cartModel = saleCartOrderItem.getModel();
            Model model = cooperationFeign.modelQueryById(saleCartOrderItem.getModelId()).getBody();
            Integer cartNum = saleCartOrderItem.getNum();//需要的数量
            Integer modelNum = model.getNum();//实际的数量
            //判断model的剩余数量
            if (modelNum < cartNum) {
                String format = String.format("%s 的所需数量 %s，大于的剩余数量 %s", model.getName(), model.getNum(), cartModel.getNum());
                log.error(format);
                throw new RuntimeException("format");
            }
            model.setNum(modelNum - cartNum);
            try {
                cooperationFeign.modelEdit(model);
            } catch (Exception e) {
                log.error("cooperationFeign修改model剩余数量失败", e);
                throw new RuntimeException("cooperationFeign修改model剩余数量失败",e);
            }

            //storehouseFeign修改store剩余数量
            Store store = model.getStore();
            store.setNum(store.getNum() - cartNum);
            try {
                storehouseFeign.storeEdit(store);
            } catch (Exception e) {
                log.error("storehouseFeign修改store剩余数量失败", e);
                throw new RuntimeException("storehouseFeign修改store剩余数量失败",e);
            }

            //storehouseFeign添加出库记录
            StoreRecord storeRecord = new StoreRecord(null, -cartNum, new Date(), model.getStoreId(), model.getId(), model.getStore(), model);
            try {
                storehouseFeign.storeRecordAdd(storeRecord);
            } catch (Exception e) {
                log.error("storehouseFeign添加出库记录失败", e);
                throw new RuntimeException("storehouseFeign添加出库记录失败",e);
            }

        }
        log.info("更新订单条目成功");
        log.info("cooperationFeign修改model剩余数量成功");
        log.info("storehouseFeign修改store剩余数量成功");
        log.info("storehouseFeign添加出库记录成功");

        int i = 1 / 0;//模拟异常，查看分布式事务管理是否成功

        //清除购物车金额
        saleCart.setTotalPrice(0.0);
        try {

            saleCartService.update(saleCart);

        } catch (Exception e) {
            log.error("清除购物车金额失败");
            throw new RuntimeException("清除购物车金额失败",e);
        }
        log.info("清除购物车金额成功");

        return insertSaleOrder;
    }

    /**
     * 付款
     *
     * @param orderId
     * @return
     */
    @Override
    public SaleOrder payOrder(int orderId) {

        //查询到该商户id的商户
        SaleOrder saleOrder = queryById(orderId);
        if (saleOrder == null) {
            log.error("该订单不存在");
            throw new RuntimeException("该订单不存在");
        }

        //订单状态非已下单状态
        if (saleOrder.getStatus() != 1) {
            log.error("该订单状态非已下单状态");
            throw new RuntimeException("该订单状态非已下单状态");
        }

        //修改订单状态为已付款
        saleOrder.setStatus(2);
        SaleOrder updateSaleOrder;
        try {
            updateSaleOrder = update(saleOrder);
        } catch (Exception e) {
            log.error("修改订单状态为已付款失败");
            throw new RuntimeException("修改订单状态为已付款失败",e);
        }
        log.info("修改订单状态为已付款成功");

        //新增付款订单记录
        SaleRecord saleRecord = new SaleRecord(null, new Date(), saleOrder.getId(), 2, saleOrder);
        try {
            saleRecordService.insert(saleRecord);
        } catch (Exception e) {
            log.error("新增付款订单记录失败");
            throw new RuntimeException("新增付款订单记录失败",e);
        }
        log.info("新增付款订单记录成功");
        return updateSaleOrder;
    }

    /**
     * 发货
     *
     * @param orderId
     * @return
     */
    @Override
    public SaleOrder shipOrder(int orderId) {
        //查询到该商户id的商户
        SaleOrder saleOrder = queryById(orderId);
        if (saleOrder == null) {
            log.error("该订单不存在");
            throw new RuntimeException("该订单不存在");
        }

        //订单状态非已付款状态
        if (saleOrder.getStatus() != 2) {
            log.error("订单状态非已付款状态");
            throw new RuntimeException("订单状态非已付款状态");
        }

        //修改订单状态为已发货
        saleOrder.setStatus(3);
        SaleOrder updateSaleOrder;
        try {
            updateSaleOrder = update(saleOrder);
        } catch (Exception e) {
            log.error("修改订单状态为已发货失败");
            throw new RuntimeException("修改订单状态为已发货失败",e);
        }
        log.info("修改订单状态为已发货成功");

        //新增发货订单记录
        SaleRecord saleRecord = new SaleRecord(null, new Date(), saleOrder.getId(), 3, saleOrder);
        try {
            saleRecordService.insert(saleRecord);
        } catch (Exception e) {
            log.error("新增发货订单记录失败");
            throw new RuntimeException("新增发货订单记录失败",e);
        }
        log.info("新增发货订单记录成功");
        return updateSaleOrder;
    }

    /**
     * 收货
     *
     * @param orderId
     * @return
     */
    @Override
    public SaleOrder receiveOrder(int orderId) {
        //查询到该商户id的商户
        SaleOrder saleOrder = queryById(orderId);
        if (saleOrder == null) {
            log.error("该订单不存在");
            throw new RuntimeException("该订单不存在");
        }

        //订单状态非已发货状态
        if (saleOrder.getStatus() != 3) {
            log.error("订单状态非已发货状态");
            throw new RuntimeException("订单状态非已发货状态");
        }

        //修改订单状态为已收货
        saleOrder.setStatus(4);
        SaleOrder updateSaleOrder;
        try {
            updateSaleOrder = update(saleOrder);
        } catch (Exception e) {
            log.error("修改订单状态为已收货失败");
            throw new RuntimeException("修改订单状态为已收货失败",e);
        }
        log.info("修改订单状态为已收货成功");

        //新增收货订单记录
        SaleRecord saleRecord = new SaleRecord(null, new Date(), saleOrder.getId(), 4, saleOrder);
        try {
            saleRecordService.insert(saleRecord);
        } catch (Exception e) {
            log.error("新增收货订单记录失败");
            throw new RuntimeException("新增收货订单记录失败",e);
        }
        log.info("新增收货订单记录成功");

        return updateSaleOrder;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SaleOrder queryById(Integer id) {
        return this.saleOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param saleOrder   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<SaleOrder> queryByPage(SaleOrder saleOrder, PageRequest pageRequest) {
        long total = this.saleOrderDao.count(saleOrder);
        return new PageImpl<>(this.saleOrderDao.queryAllByLimit(saleOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrder insert(SaleOrder saleOrder) {
        this.saleOrderDao.insert(saleOrder);
        return saleOrder;
    }

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrder update(SaleOrder saleOrder) {
        this.saleOrderDao.update(saleOrder);
        return this.queryById(saleOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleOrderDao.deleteById(id) > 0;
    }
}
