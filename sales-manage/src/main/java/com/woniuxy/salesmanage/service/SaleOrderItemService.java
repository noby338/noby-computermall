package com.woniuxy.salesmanage.service;

import com.woniuxy.commonentity.entity.SaleOrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 订单条目表(SaleOrderItem)表服务接口
 *
 * @author Noby
 * @since 2022-08-29 01:23:50
 */
public interface SaleOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleOrderItem queryById(Integer id);

    /**
     * 分页查询
     *
     * @param saleOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SaleOrderItem> queryByPage(SaleOrderItem saleOrderItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param saleOrderItem 实例对象
     * @return 实例对象
     */
    SaleOrderItem insert(SaleOrderItem saleOrderItem);

    /**
     * 修改数据
     *
     * @param saleOrderItem 实例对象
     * @return 实例对象
     */
    SaleOrderItem update(SaleOrderItem saleOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
