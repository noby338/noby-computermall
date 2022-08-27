package com.woniuxy.financialmanage.service.impl;

import com.woniuxy.commonentity.entity.PurchaseRecord;
import com.woniuxy.financialmanage.dao.PurchaseRecordDao;
import com.woniuxy.financialmanage.service.PurchaseRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 采购记录(PurchaseRecord)表服务实现类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Service("purchaseRecordService")
public class PurchaseRecordServiceImpl implements PurchaseRecordService {
    @Resource
    private PurchaseRecordDao purchaseRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseRecord queryById(Integer id) {
        return this.purchaseRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param purchaseRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<PurchaseRecord> queryByPage(PurchaseRecord purchaseRecord, PageRequest pageRequest) {
        long total = this.purchaseRecordDao.count(purchaseRecord);
        return new PageImpl<>(this.purchaseRecordDao.queryAllByLimit(purchaseRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param purchaseRecord 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseRecord insert(PurchaseRecord purchaseRecord) {
        this.purchaseRecordDao.insert(purchaseRecord);
        return purchaseRecord;
    }

    /**
     * 修改数据
     *
     * @param purchaseRecord 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseRecord update(PurchaseRecord purchaseRecord) {
        this.purchaseRecordDao.update(purchaseRecord);
        return this.queryById(purchaseRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.purchaseRecordDao.deleteById(id) > 0;
    }
}
