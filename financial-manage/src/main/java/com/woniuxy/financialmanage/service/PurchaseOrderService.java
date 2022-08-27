package com.woniuxy.financialmanage.service;

import com.woniuxy.commonentity.entity.PurchaseOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 采购订单(PurchaseOrder)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface PurchaseOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseOrder queryById(Integer id);

    /**
     * 分页查询
     *
     * @param purchaseOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<PurchaseOrder> queryByPage(PurchaseOrder purchaseOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    PurchaseOrder insert(PurchaseOrder purchaseOrder);

    /**
     * 修改数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    PurchaseOrder update(PurchaseOrder purchaseOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
