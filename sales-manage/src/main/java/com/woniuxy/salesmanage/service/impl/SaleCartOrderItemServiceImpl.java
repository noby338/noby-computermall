package com.woniuxy.salesmanage.service.impl;

import com.woniuxy.commonentity.entity.SaleCartOrderItem;
import com.woniuxy.salesmanage.dao.SaleCartOrderItemDao;
import com.woniuxy.salesmanage.service.SaleCartOrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 出售购入车条目(SaleCartOrderItem)表服务实现类
 *
 * @author Noby
 * @since 2022-08-29 15:48:26
 */
@Service("saleCartOrderItemService")
public class SaleCartOrderItemServiceImpl implements SaleCartOrderItemService {
    @Resource
    private SaleCartOrderItemDao saleCartOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SaleCartOrderItem queryById(Integer id) {
        return this.saleCartOrderItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param saleCartOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SaleCartOrderItem> queryByPage(SaleCartOrderItem saleCartOrderItem, PageRequest pageRequest) {
        long total = this.saleCartOrderItemDao.count(saleCartOrderItem);
        return new PageImpl<>(this.saleCartOrderItemDao.queryAllByLimit(saleCartOrderItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param saleCartOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public SaleCartOrderItem insert(SaleCartOrderItem saleCartOrderItem) {
        this.saleCartOrderItemDao.insert(saleCartOrderItem);
        return saleCartOrderItem;
    }

    /**
     * 修改数据
     *
     * @param saleCartOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public SaleCartOrderItem update(SaleCartOrderItem saleCartOrderItem) {
        this.saleCartOrderItemDao.update(saleCartOrderItem);
        return this.queryById(saleCartOrderItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleCartOrderItemDao.deleteById(id) > 0;
    }
}
