package com.woniuxy.cooperationmanage.service.impl;

import com.woniuxy.commonentity.entity.Components;
import com.woniuxy.cooperationmanage.dao.ComponentsDao;
import com.woniuxy.cooperationmanage.service.ComponentsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 各电脑配件(Components)表服务实现类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Service("componentsService")
public class ComponentsServiceImpl implements ComponentsService {
    @Resource
    private ComponentsDao componentsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Components queryById(Integer id) {
        return this.componentsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param components 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Components> queryByPage(Components components, PageRequest pageRequest) {
        long total = this.componentsDao.count(components);
        return new PageImpl<>(this.componentsDao.queryAllByLimit(components, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param components 实例对象
     * @return 实例对象
     */
    @Override
    public Components insert(Components components) {
        this.componentsDao.insert(components);
        return components;
    }

    /**
     * 修改数据
     *
     * @param components 实例对象
     * @return 实例对象
     */
    @Override
    public Components update(Components components) {
        this.componentsDao.update(components);
        return this.queryById(components.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.componentsDao.deleteById(id) > 0;
    }
}
