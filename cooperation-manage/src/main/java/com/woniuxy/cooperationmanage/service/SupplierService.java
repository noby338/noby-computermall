package com.woniuxy.cooperationmanage.service;

import com.woniuxy.cooperationmanage.entity.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 供应商(Supplier)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 19:43:56
 */
public interface SupplierService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Supplier queryById(Integer id);

    /**
     * 分页查询
     *
     * @param supplier 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Supplier> queryByPage(Supplier supplier, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param supplier 实例对象
     * @return 实例对象
     */
    Supplier insert(Supplier supplier);

    /**
     * 修改数据
     *
     * @param supplier 实例对象
     * @return 实例对象
     */
    Supplier update(Supplier supplier);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
