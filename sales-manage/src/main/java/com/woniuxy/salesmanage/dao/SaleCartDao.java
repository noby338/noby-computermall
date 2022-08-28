package com.woniuxy.salesmanage.dao;

import com.woniuxy.commonentity.entity.SaleCart;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 销售购物车(SaleCart)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
public interface SaleCartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleCart queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param saleCart 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SaleCart> queryAllByLimit(@Param("saleCart") SaleCart saleCart, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param saleCart 查询条件
     * @return 总行数
     */
    long count(SaleCart saleCart);

    /**
     * 新增数据
     *
     * @param saleCart 实例对象
     * @return 影响行数
     */
    int insert(SaleCart saleCart);

    /**
     * 修改数据
     *
     * @param saleCart 实例对象
     * @return 影响行数
     */
    int update(SaleCart saleCart);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

