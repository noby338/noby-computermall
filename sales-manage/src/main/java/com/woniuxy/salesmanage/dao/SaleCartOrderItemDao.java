package com.woniuxy.salesmanage.dao;

import com.woniuxy.commonentity.entity.SaleCartOrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 出售购入车条目(SaleCartOrderItem)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-29 15:48:26
 */
public interface SaleCartOrderItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleCartOrderItem queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param saleCartOrderItem 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SaleCartOrderItem> queryAllByLimit(@Param("saleCartOrderItem") SaleCartOrderItem saleCartOrderItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param saleCartOrderItem 查询条件
     * @return 总行数
     */
    long count(SaleCartOrderItem saleCartOrderItem);

    /**
     * 新增数据
     *
     * @param saleCartOrderItem 实例对象
     * @return 影响行数
     */
    int insert(SaleCartOrderItem saleCartOrderItem);

    /**
     * 修改数据
     *
     * @param saleCartOrderItem 实例对象
     * @return 影响行数
     */
    int update(SaleCartOrderItem saleCartOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

