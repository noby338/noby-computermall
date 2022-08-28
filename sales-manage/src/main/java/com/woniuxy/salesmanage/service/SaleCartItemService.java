package com.woniuxy.salesmanage.service;

import com.woniuxy.commonentity.entity.SaleCartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 出售购入车条目(SaleCartItem)表服务接口
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
public interface SaleCartItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleCartItem queryById(Integer id);

    /**
     * 分页查询
     *
     * @param saleCartItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SaleCartItem> queryByPage(SaleCartItem saleCartItem, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param saleCartItem 实例对象
     * @return 实例对象
     */
    SaleCartItem insert(SaleCartItem saleCartItem);

    /**
     * 修改数据
     *
     * @param saleCartItem 实例对象
     * @return 实例对象
     */
    SaleCartItem update(SaleCartItem saleCartItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
