package com.woniuxy.cooperationmanage.service.impl;

import com.woniuxy.cooperationmanage.entity.Supplier;
import com.woniuxy.cooperationmanage.dao.SupplierDao;
import com.woniuxy.cooperationmanage.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 供应商(Supplier)表服务实现类
 *
 * @author Noby
 * @since 2022-08-26 22:03:12
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierDao supplierDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Supplier queryById(Integer id) {
        return this.supplierDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param supplier 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Supplier> queryByPage(Supplier supplier, PageRequest pageRequest) {
        long total = this.supplierDao.count(supplier);
        return new PageImpl<>(this.supplierDao.queryAllByLimit(supplier, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param supplier 实例对象
     * @return 实例对象
     */
    @Override
    public Supplier insert(Supplier supplier) {
        this.supplierDao.insert(supplier);
        return supplier;
    }

    /**
     * 修改数据
     *
     * @param supplier 实例对象
     * @return 实例对象
     */
    @Override
    public Supplier update(Supplier supplier) {
        this.supplierDao.update(supplier);
        return this.queryById(supplier.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.supplierDao.deleteById(id) > 0;
    }
}
