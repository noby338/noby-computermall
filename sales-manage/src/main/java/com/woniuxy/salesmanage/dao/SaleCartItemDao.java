package com.woniuxy.salesmanage.dao;

import com.woniuxy.commonentity.entity.SaleCartItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 出售购入车条目(SaleCartItem)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
public interface SaleCartItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleCartItem queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param saleCartItem 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SaleCartItem> queryAllByLimit(@Param("saleCartItem") SaleCartItem saleCartItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param saleCartItem 查询条件
     * @return 总行数
     */
    long count(SaleCartItem saleCartItem);

    /**
     * 新增数据
     *
     * @param saleCartItem 实例对象
     * @return 影响行数
     */
    int insert(SaleCartItem saleCartItem);

    /**
     * 修改数据
     *
     * @param saleCartItem 实例对象
     * @return 影响行数
     */
    int update(SaleCartItem saleCartItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

