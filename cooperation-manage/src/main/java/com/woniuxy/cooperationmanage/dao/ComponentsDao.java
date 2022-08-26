package com.woniuxy.cooperationmanage.dao;

import com.woniuxy.cooperationmanage.entity.Components;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Components)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-26 21:53:36
 */
public interface ComponentsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Components queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param components 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Components> queryAllByLimit(@Param("components") Components components, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param components 查询条件
     * @return 总行数
     */
    long count(Components components);

    /**
     * 新增数据
     *
     * @param components 实例对象
     * @return 影响行数
     */
    int insert(Components components);

    /**
     * 修改数据
     *
     * @param components 实例对象
     * @return 影响行数
     */
    int update(Components components);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

