package com.woniuxy.storehousemanage.service.impl;

import com.woniuxy.commonentity.entity.Store;
import com.woniuxy.storehousemanage.dao.StoreDao;
import com.woniuxy.storehousemanage.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 库存(Store)表服务实现类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Service("storeService")
public class StoreServiceImpl implements StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Store queryById(Integer id) {
        return this.storeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param store 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Store> queryByPage(Store store, PageRequest pageRequest) {
        long total = this.storeDao.count(store);
        return new PageImpl<>(this.storeDao.queryAllByLimit(store, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param store 实例对象
     * @return 实例对象
     */
    @Override
    public Store insert(Store store) {
        this.storeDao.insert(store);
        return store;
    }

    /**
     * 修改数据
     *
     * @param store 实例对象
     * @return 实例对象
     */
    @Override
    public Store update(Store store) {
        this.storeDao.update(store);
        return this.queryById(store.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.storeDao.deleteById(id) > 0;
    }
}
