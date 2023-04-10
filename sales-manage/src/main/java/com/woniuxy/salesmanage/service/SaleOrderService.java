package com.woniuxy.salesmanage.service;

import com.woniuxy.commonentity.entity.SaleOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 出售订单(SaleOrder)表服务接口
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
public interface SaleOrderService {
    /**
     * 下单
     * @param clientId
     * @return
     */
    SaleOrder placeOrder(int clientId);

    /**
     * 付款
     * @param orderId
     * @return
     */
    SaleOrder payOrder(int orderId);

    /**
     * 发货
     * @param orderId
     * @return
     */
    SaleOrder shipOrder(int orderId);

    /**
     * 收货
     * @param orderId
     * @return
     */
    SaleOrder receiveOrder(int orderId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleOrder queryById(Integer id);

    /**
     * 分页查询
     *
     * @param saleOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SaleOrder> queryByPage(SaleOrder saleOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    SaleOrder insert(SaleOrder saleOrder);

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    SaleOrder update(SaleOrder saleOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
