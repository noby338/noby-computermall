package com.woniuxy.cooperationmanage.dao;

import com.woniuxy.cooperationmanage.entity.Model;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 各配件型号(Model)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-26 23:20:54
 */
public interface ModelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Model queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param model 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Model> queryAllByLimit(@Param("model") Model model, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param model 查询条件
     * @return 总行数
     */
    long count(Model model);

    /**
     * 新增数据
     *
     * @param model 实例对象
     * @return 影响行数
     */
    int insert(Model model);

    /**
     * 修改数据
     *
     * @param model 实例对象
     * @return 影响行数
     */
    int update(Model model);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

