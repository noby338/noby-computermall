package com.woniuxy.salesmanage.service;

import com.woniuxy.commonentity.entity.SaleCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 销售购物车(SaleCart)表服务接口
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
public interface SaleCartService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleCart queryById(Integer id);

    /**
     * 分页查询
     *
     * @param saleCart 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SaleCart> queryByPage(SaleCart saleCart, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param saleCart 实例对象
     * @return 实例对象
     */
    SaleCart insert(SaleCart saleCart);

    /**
     * 修改数据
     *
     * @param saleCart 实例对象
     * @return 实例对象
     */
    SaleCart update(SaleCart saleCart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
