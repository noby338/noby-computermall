package com.woniuxy.salesmanage.dao;

import com.woniuxy.commonentity.entity.SaleOrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 订单条目表(SaleOrderItem)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-29 01:23:50
 */
public interface SaleOrderItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleOrderItem queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param saleOrderItem 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SaleOrderItem> queryAllByLimit(@Param("saleOrderItem") SaleOrderItem saleOrderItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param saleOrderItem 查询条件
     * @return 总行数
     */
    long count(SaleOrderItem saleOrderItem);

    /**
     * 新增数据
     *
     * @param saleOrderItem 实例对象
     * @return 影响行数
     */
    int insert(SaleOrderItem saleOrderItem);

    /**
     * 修改数据
     *
     * @param saleOrderItem 实例对象
     * @return 影响行数
     */
    int update(SaleOrderItem saleOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

