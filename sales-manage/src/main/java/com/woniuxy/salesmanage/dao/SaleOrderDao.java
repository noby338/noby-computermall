package com.woniuxy.salesmanage.dao;

import com.woniuxy.commonentity.entity.SaleOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 出售订单(SaleOrder)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
public interface SaleOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleOrder queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param saleOrder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SaleOrder> queryAllByLimit(@Param("saleOrder") SaleOrder saleOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param saleOrder 查询条件
     * @return 总行数
     */
    long count(SaleOrder saleOrder);

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 影响行数
     */
    int insert(SaleOrder saleOrder);

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 影响行数
     */
    int update(SaleOrder saleOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

