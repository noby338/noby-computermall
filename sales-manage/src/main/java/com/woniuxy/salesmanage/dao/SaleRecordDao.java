package com.woniuxy.salesmanage.dao;

import com.woniuxy.commonentity.entity.SaleRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 出售记录(SaleRecord)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
public interface SaleRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param saleRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SaleRecord> queryAllByLimit(@Param("saleRecord") SaleRecord saleRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param saleRecord 查询条件
     * @return 总行数
     */
    long count(SaleRecord saleRecord);

    /**
     * 新增数据
     *
     * @param saleRecord 实例对象
     * @return 影响行数
     */
    int insert(SaleRecord saleRecord);

    /**
     * 修改数据
     *
     * @param saleRecord 实例对象
     * @return 影响行数
     */
    int update(SaleRecord saleRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

