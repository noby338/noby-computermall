package com.woniuxy.salesmanage.service;

import com.woniuxy.commonentity.entity.SaleCartOrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 出售购入车条目(SaleCartOrderItem)表服务接口
 *
 * @author Noby
 * @since 2022-08-29 15:48:26
 */
public interface SaleCartOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleCartOrderItem queryById(Integer id);

    /**
     * 分页查询
     *
     * @param saleCartOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SaleCartOrderItem> queryByPage(SaleCartOrderItem saleCartOrderItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param saleCartOrderItem 实例对象
     * @return 实例对象
     */
    SaleCartOrderItem insert(SaleCartOrderItem saleCartOrderItem);

    /**
     * 修改数据
     *
     * @param saleCartOrderItem 实例对象
     * @return 实例对象
     */
    SaleCartOrderItem update(SaleCartOrderItem saleCartOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
