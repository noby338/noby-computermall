package com.woniuxy.storehousemanage.dao;

import com.woniuxy.commonentity.entity.StoreRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 出库入库记录(StoreRecord)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-27 23:38:38
 */
public interface StoreRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StoreRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param storeRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<StoreRecord> queryAllByLimit(@Param("storeRecord") StoreRecord storeRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param storeRecord 查询条件
     * @return 总行数
     */
    long count(StoreRecord storeRecord);

    /**
     * 新增数据
     *
     * @param storeRecord 实例对象
     * @return 影响行数
     */
    int insert(StoreRecord storeRecord);

    /**
     * 修改数据
     *
     * @param storeRecord 实例对象
     * @return 影响行数
     */
    int update(StoreRecord storeRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

