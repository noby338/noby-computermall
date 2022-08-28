package com.woniuxy.salesmanage.service.impl;

import com.woniuxy.commonentity.entity.SaleRecord;
import com.woniuxy.salesmanage.dao.SaleRecordDao;
import com.woniuxy.salesmanage.service.SaleRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 出售记录(SaleRecord)表服务实现类
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@Service("saleRecordService")
public class SaleRecordServiceImpl implements SaleRecordService {
    @Resource
    private SaleRecordDao saleRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SaleRecord queryById(Integer id) {
        return this.saleRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param saleRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SaleRecord> queryByPage(SaleRecord saleRecord, PageRequest pageRequest) {
        long total = this.saleRecordDao.count(saleRecord);
        return new PageImpl<>(this.saleRecordDao.queryAllByLimit(saleRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param saleRecord 实例对象
     * @return 实例对象
     */
    @Override
    public SaleRecord insert(SaleRecord saleRecord) {
        this.saleRecordDao.insert(saleRecord);
        return saleRecord;
    }

    /**
     * 修改数据
     *
     * @param saleRecord 实例对象
     * @return 实例对象
     */
    @Override
    public SaleRecord update(SaleRecord saleRecord) {
        this.saleRecordDao.update(saleRecord);
        return this.queryById(saleRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleRecordDao.deleteById(id) > 0;
    }
}
