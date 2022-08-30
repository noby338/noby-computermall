package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.*;
import com.woniuxy.salesmanage.openFeign.CooperationFeign;
import com.woniuxy.salesmanage.openFeign.StorehouseFeign;
import com.woniuxy.salesmanage.service.*;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 出售订单(SaleOrder)表控制层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@RestController
@RequestMapping("saleOrder")
@Slf4j
public class SaleOrderController {
    /**
     * 服务对象
     */
    @Resource
    private SaleOrderService saleOrderService;

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
     * 添加订单
     *
     * @return 单条数据
     */
    @GetMapping("placeOrder/{clientId}")
    @GlobalTransactional(name = "placeOrderTransactional",rollbackFor = Exception.class)
    public ResponseEntity<SaleOrder> placeOrder(@PathVariable("clientId") int clientId) {
        log.info("placeOrder ===> clientId = {}", clientId);

        //查询到该商户id的商户
        SaleOrder saleOrder = new SaleOrder();
        Client client = clientService.queryById(clientId);
        if (client == null) {
            log.error("该用户不存在");
            return new ResponseEntity("该用户不存在", HttpStatus.INTERNAL_SERVER_ERROR);
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
            insertSaleOrder = saleOrderService.insert(saleOrder);
        } catch (Exception e) {
            log.error("添加订单失败", e);
            return new ResponseEntity("添加订单失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("添加订单成功");

        //添加订单记录
        SaleRecord saleRecord = new SaleRecord(null, new Date(), saleOrder.getId(), 1, saleOrder);
        try {
            saleRecordService.insert(saleRecord);
        } catch (Exception e) {
            log.error("添加订单记录失败", e);
            return new ResponseEntity("添加订单记录失败", HttpStatus.INTERNAL_SERVER_ERROR);
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
                return new ResponseEntity("更新订单条目失败", HttpStatus.INTERNAL_SERVER_ERROR);
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
                return new ResponseEntity(format, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            model.setNum(modelNum - cartNum);
            try {
                cooperationFeign.modelEdit(model);
            } catch (Exception e) {
                log.error("cooperationFeign修改model剩余数量失败", e);
                return new ResponseEntity("cooperationFeign修改model剩余数量失败", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            //storehouseFeign修改store剩余数量
            Store store = model.getStore();
            store.setNum(store.getNum() - cartNum);
            try {
                storehouseFeign.storeEdit(store);
            } catch (Exception e) {
                log.error("storehouseFeign修改store剩余数量失败", e);
                return new ResponseEntity("storehouseFeign修改store剩余数量失败", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            //storehouseFeign添加出库记录
            StoreRecord storeRecord = new StoreRecord(null, - cartNum, new Date(), model.getStoreId(), model.getId(), model.getStore(), model);
            try {
                storehouseFeign.storeRecordAdd(storeRecord);
            } catch (Exception e) {
                log.error("storehouseFeign添加出库记录失败", e);
                return new ResponseEntity("storehouseFeign添加出库记录失败", HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        log.info("更新订单条目成功");
        log.info("cooperationFeign修改model剩余数量成功");
        log.info("storehouseFeign修改store剩余数量成功");
        log.info("storehouseFeign添加出库记录成功");

//        int i = 1/0;//模拟异常，查看分布式事务管理是否成功

        //清除购物车金额
        saleCart.setTotalPrice(0.0);
        try {
            saleCartService.update(saleCart);
        } catch (Exception e) {
            log.error("清除购物车金额失败");
            return new ResponseEntity("清除购物车金额失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("清除购物车金额成功");

        return ResponseEntity.ok(insertSaleOrder);
    }


    /**
     * 付款
     *
     * @return 单条数据
     */
    @GetMapping("payOrder/{orderId}")
    public ResponseEntity<SaleOrder> payOrder(@PathVariable("orderId") int orderId) {
        log.info("payOrder ===> orderId = {}", orderId);

        //查询到该商户id的商户
        SaleOrder saleOrder = saleOrderService.queryById(orderId);
        if (saleOrder == null) {
            log.error("该订单不存在");
            return new ResponseEntity("该订单不存在", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //订单状态非已下单状态
        if (saleOrder.getStatus() != 1) {
            log.error("该订单状态非已下单状态");
            return new ResponseEntity("该订单状态非已下单状态", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //修改订单状态为已付款
        saleOrder.setStatus(2);
        SaleOrder updateSaleOrder;
        try {
            updateSaleOrder = saleOrderService.update(saleOrder);
        } catch (Exception e) {
            log.error("修改订单状态为已付款失败");
            return new ResponseEntity("修改订单状态为已付款失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("修改订单状态为已付款成功");

        //新增付款订单记录
        SaleRecord saleRecord = new SaleRecord(null, new Date(), saleOrder.getId(), 2, saleOrder);
        try {
            saleRecordService.insert(saleRecord);
        } catch (Exception e) {
            log.error("新增付款订单记录失败");
            return new ResponseEntity("新增付款订单记录失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("新增付款订单记录成功");

        return ResponseEntity.ok(updateSaleOrder);
    }

    /**
     * 发货
     *
     * @return 单条数据
     */
    @GetMapping("shipOrder/{orderId}")
    public ResponseEntity<SaleOrder> shipOrder(@PathVariable("orderId") int orderId) {
        log.info("shipOrder ===> orderId = {}", orderId);

        //查询到该商户id的商户
        SaleOrder saleOrder = saleOrderService.queryById(orderId);
        if (saleOrder == null) {
            log.error("该订单不存在");
            return new ResponseEntity("该订单不存在", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //订单状态非已付款状态
        if (saleOrder.getStatus() != 2) {
            log.error("订单状态非已付款状态");
            return new ResponseEntity("订单状态非已付款状态", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //修改订单状态为已发货
        saleOrder.setStatus(3);
        SaleOrder updateSaleOrder;
        try {
            updateSaleOrder = saleOrderService.update(saleOrder);
        } catch (Exception e) {
            log.error("修改订单状态为已发货失败");
            return new ResponseEntity("修改订单状态为已发货失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("修改订单状态为已发货成功");

        //新增发货订单记录
        SaleRecord saleRecord = new SaleRecord(null, new Date(), saleOrder.getId(), 3, saleOrder);
        try {
            saleRecordService.insert(saleRecord);
        } catch (Exception e) {
            log.error("新增发货订单记录失败");
            return new ResponseEntity("新增发货订单记录失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("新增发货订单记录成功");

        return ResponseEntity.ok(updateSaleOrder);
    }

    /**
     * 收货
     *
     * @return 单条数据
     */
    @GetMapping("receiveOrder/{orderId}")
    public ResponseEntity<SaleOrder> receiveOrder(@PathVariable("orderId") int orderId) {
        log.info("receiveOrder ===> orderId = {}", orderId);

        //查询到该商户id的商户
        SaleOrder saleOrder = saleOrderService.queryById(orderId);
        if (saleOrder == null) {
            log.error("该订单不存在");
            return new ResponseEntity("该订单不存在", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //订单状态非已发货状态
        if (saleOrder.getStatus() != 3) {
            log.error("订单状态非已发货状态");
            return new ResponseEntity("订单状态非已发货状态", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //修改订单状态为已收货
        saleOrder.setStatus(4);
        SaleOrder updateSaleOrder;
        try {
            updateSaleOrder = saleOrderService.update(saleOrder);
        } catch (Exception e) {
            log.error("修改订单状态为已收货失败");
            return new ResponseEntity("修改订单状态为已收货失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("修改订单状态为已收货成功");

        //新增收货订单记录
        SaleRecord saleRecord = new SaleRecord(null, new Date(), saleOrder.getId(), 4, saleOrder);
        try {
            saleRecordService.insert(saleRecord);
        } catch (Exception e) {
            log.error("新增收货订单记录失败");
            return new ResponseEntity("新增收货订单记录失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("新增收货订单记录成功");

        return ResponseEntity.ok(updateSaleOrder);
    }

    /**
     * 分页查询
     *
     * @param saleOrder 筛选条件
     * @param page      当前页
     * @param size      页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<SaleOrder>> queryByPage(@RequestBody SaleOrder saleOrder, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> saleOrder = {}, page = {}, size = {}", saleOrder, page, size);
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(this.saleOrderService.queryByPage(saleOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SaleOrder> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.saleOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param saleOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SaleOrder> add(@RequestBody SaleOrder saleOrder) {
        log.info("add ===> saleOrder = {}", saleOrder);
        return ResponseEntity.ok(this.saleOrderService.insert(saleOrder));
    }

    /**
     * 编辑数据
     *
     * @param saleOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SaleOrder> edit(@RequestBody SaleOrder saleOrder) {
        log.info("edit ===> saleOrder = {}", saleOrder);
        return ResponseEntity.ok(this.saleOrderService.update(saleOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        log.info("deleteById ===> id = {}", id);
        return ResponseEntity.ok(this.saleOrderService.deleteById(id));
    }

}

