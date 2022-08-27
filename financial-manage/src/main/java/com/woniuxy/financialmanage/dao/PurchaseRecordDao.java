package com.woniuxy.financialmanage.dao;

import com.woniuxy.commonentity.entity.PurchaseRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 采购记录(PurchaseRecord)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface PurchaseRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param purchaseRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PurchaseRecord> queryAllByLimit(@Param("purchaseRecord") PurchaseRecord purchaseRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param purchaseRecord 查询条件
     * @return 总行数
     */
    long count(PurchaseRecord purchaseRecord);

    /**
     * 新增数据
     *
     * @param purchaseRecord 实例对象
     * @return 影响行数
     */
    int insert(PurchaseRecord purchaseRecord);

    /**
     * 修改数据
     *
     * @param purchaseRecord 实例对象
     * @return 影响行数
     */
    int update(PurchaseRecord purchaseRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

