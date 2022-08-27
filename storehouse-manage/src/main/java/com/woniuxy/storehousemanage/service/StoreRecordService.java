package com.woniuxy.storehousemanage.service;

import com.woniuxy.commonentity.entity.StoreRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 出库入库记录(StoreRecord)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 23:38:38
 */
public interface StoreRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StoreRecord queryById(Integer id);

    /**
     * 分页查询
     *
     * @param storeRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<StoreRecord> queryByPage(StoreRecord storeRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param storeRecord 实例对象
     * @return 实例对象
     */
    StoreRecord insert(StoreRecord storeRecord);

    /**
     * 修改数据
     *
     * @param storeRecord 实例对象
     * @return 实例对象
     */
    StoreRecord update(StoreRecord storeRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
