package com.woniuxy.financialmanage.service.impl;

import com.woniuxy.commonentity.entity.StoreRecord;
import com.woniuxy.financialmanage.dao.StoreRecordDao;
import com.woniuxy.financialmanage.service.StoreRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 出库入库记录(StoreRecord)表服务实现类
 *
 * @author Noby
 * @since 2022-08-27 23:38:38
 */
@Service("storeRecordService")
public class StoreRecordServiceImpl implements StoreRecordService {
    @Resource
    private StoreRecordDao storeRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StoreRecord queryById(Integer id) {
        return this.storeRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param storeRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<StoreRecord> queryByPage(StoreRecord storeRecord, PageRequest pageRequest) {
        long total = this.storeRecordDao.count(storeRecord);
        return new PageImpl<>(this.storeRecordDao.queryAllByLimit(storeRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param storeRecord 实例对象
     * @return 实例对象
     */
    @Override
    public StoreRecord insert(StoreRecord storeRecord) {
        this.storeRecordDao.insert(storeRecord);
        return storeRecord;
    }

    /**
     * 修改数据
     *
     * @param storeRecord 实例对象
     * @return 实例对象
     */
    @Override
    public StoreRecord update(StoreRecord storeRecord) {
        this.storeRecordDao.update(storeRecord);
        return this.queryById(storeRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.storeRecordDao.deleteById(id) > 0;
    }
}
