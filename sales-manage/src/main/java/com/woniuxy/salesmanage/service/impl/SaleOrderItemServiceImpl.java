package com.woniuxy.salesmanage.service.impl;

import com.woniuxy.commonentity.entity.SaleOrderItem;
import com.woniuxy.salesmanage.dao.SaleOrderItemDao;
import com.woniuxy.salesmanage.service.SaleOrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 订单条目表(SaleOrderItem)表服务实现类
 *
 * @author Noby
 * @since 2022-08-29 01:23:50
 */
@Service("saleOrderItemService")
public class SaleOrderItemServiceImpl implements SaleOrderItemService {
    @Resource
    private SaleOrderItemDao saleOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SaleOrderItem queryById(Integer id) {
        return this.saleOrderItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param saleOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SaleOrderItem> queryByPage(SaleOrderItem saleOrderItem, PageRequest pageRequest) {
        long total = this.saleOrderItemDao.count(saleOrderItem);
        return new PageImpl<>(this.saleOrderItemDao.queryAllByLimit(saleOrderItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param saleOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrderItem insert(SaleOrderItem saleOrderItem) {
        this.saleOrderItemDao.insert(saleOrderItem);
        return saleOrderItem;
    }

    /**
     * 修改数据
     *
     * @param saleOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrderItem update(SaleOrderItem saleOrderItem) {
        this.saleOrderItemDao.update(saleOrderItem);
        return this.queryById(saleOrderItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleOrderItemDao.deleteById(id) > 0;
    }
}
