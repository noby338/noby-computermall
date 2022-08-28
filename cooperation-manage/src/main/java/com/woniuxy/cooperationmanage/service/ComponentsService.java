package com.woniuxy.cooperationmanage.service;

import com.woniuxy.commonentity.entity.Components;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 各电脑配件(Components)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface ComponentsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Components queryById(Integer id);

    /**
     * 分页查询
     *
     * @param components 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Components> queryByPage(Components components, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param components 实例对象
     * @return 实例对象
     */
    Components insert(Components components);

    /**
     * 修改数据
     *
     * @param components 实例对象
     * @return 实例对象
     */
    Components update(Components components);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
