package com.woniuxy.financialmanage.dao;

import com.woniuxy.commonentity.entity.PurchaseOrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 采购订单条目(PurchaseOrderItem)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface PurchaseOrderItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseOrderItem queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param purchaseOrderItem 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PurchaseOrderItem> queryAllByLimit(@Param("purchaseOrderItem") PurchaseOrderItem purchaseOrderItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param purchaseOrderItem 查询条件
     * @return 总行数
     */
    long count(PurchaseOrderItem purchaseOrderItem);

    /**
     * 新增数据
     *
     * @param purchaseOrderItem 实例对象
     * @return 影响行数
     */
    int insert(PurchaseOrderItem purchaseOrderItem);

    /**
     * 修改数据
     *
     * @param purchaseOrderItem 实例对象
     * @return 影响行数
     */
    int update(PurchaseOrderItem purchaseOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

