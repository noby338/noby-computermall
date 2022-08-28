package com.woniuxy.cooperationmanage.dao;

import com.woniuxy.commonentity.entity.Supplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 供应商(Supplier)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface SupplierDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Supplier queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param supplier 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Supplier> queryAllByLimit(@Param("supplier") Supplier supplier, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param supplier 查询条件
     * @return 总行数
     */
    long count(Supplier supplier);

    /**
     * 新增数据
     *
     * @param supplier 实例对象
     * @return 影响行数
     */
    int insert(Supplier supplier);

    /**
     * 修改数据
     *
     * @param supplier 实例对象
     * @return 影响行数
     */
    int update(Supplier supplier);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

