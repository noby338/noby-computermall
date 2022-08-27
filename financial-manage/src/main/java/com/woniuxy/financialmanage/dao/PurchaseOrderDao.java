package com.woniuxy.financialmanage.dao;

import com.woniuxy.commonentity.entity.PurchaseOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 采购订单(PurchaseOrder)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface PurchaseOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseOrder queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param purchaseOrder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PurchaseOrder> queryAllByLimit(@Param("purchaseOrder") PurchaseOrder purchaseOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param purchaseOrder 查询条件
     * @return 总行数
     */
    long count(PurchaseOrder purchaseOrder);

    /**
     * 新增数据
     *
     * @param purchaseOrder 实例对象
     * @return 影响行数
     */
    int insert(PurchaseOrder purchaseOrder);

    /**
     * 修改数据
     *
     * @param purchaseOrder 实例对象
     * @return 影响行数
     */
    int update(PurchaseOrder purchaseOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

