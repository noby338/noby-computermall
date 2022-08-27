package com.woniuxy.cooperationmanage.service;

import com.woniuxy.cooperationmanage.entity.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 各配件型号(Model)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 19:43:17
 */
public interface ModelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Model queryById(Integer id);

    /**
     * 分页查询
     *
     * @param model 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Model> queryByPage(Model model, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param model 实例对象
     * @return 实例对象
     */
    Model insert(Model model);

    /**
     * 修改数据
     *
     * @param model 实例对象
     * @return 实例对象
     */
    Model update(Model model);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
