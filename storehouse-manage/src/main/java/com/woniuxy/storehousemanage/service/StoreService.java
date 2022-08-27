package com.woniuxy.storehousemanage.service;

import com.woniuxy.commonentity.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 库存(Store)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface StoreService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Store queryById(Integer id);

    /**
     * 分页查询
     *
     * @param store 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Store> queryByPage(Store store, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param store 实例对象
     * @return 实例对象
     */
    Store insert(Store store);

    /**
     * 修改数据
     *
     * @param store 实例对象
     * @return 实例对象
     */
    Store update(Store store);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
