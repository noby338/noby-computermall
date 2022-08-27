package com.woniuxy.financialmanage.service;

import com.woniuxy.commonentity.entity.PurchaseOrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 采购订单条目(PurchaseOrderItem)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface PurchaseOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseOrderItem queryById(Integer id);

    /**
     * 分页查询
     *
     * @param purchaseOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<PurchaseOrderItem> queryByPage(PurchaseOrderItem purchaseOrderItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param purchaseOrderItem 实例对象
     * @return 实例对象
     */
    PurchaseOrderItem insert(PurchaseOrderItem purchaseOrderItem);

    /**
     * 修改数据
     *
     * @param purchaseOrderItem 实例对象
     * @return 实例对象
     */
    PurchaseOrderItem update(PurchaseOrderItem purchaseOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
