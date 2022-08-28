package com.woniuxy.salesmanage.service.impl;

import com.woniuxy.commonentity.entity.SaleOrder;
import com.woniuxy.salesmanage.dao.SaleOrderDao;
import com.woniuxy.salesmanage.service.SaleOrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 出售订单(SaleOrder)表服务实现类
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@Service("saleOrderService")
public class SaleOrderServiceImpl implements SaleOrderService {
    @Resource
    private SaleOrderDao saleOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SaleOrder queryById(Integer id) {
        return this.saleOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param saleOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SaleOrder> queryByPage(SaleOrder saleOrder, PageRequest pageRequest) {
        long total = this.saleOrderDao.count(saleOrder);
        return new PageImpl<>(this.saleOrderDao.queryAllByLimit(saleOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrder insert(SaleOrder saleOrder) {
        this.saleOrderDao.insert(saleOrder);
        return saleOrder;
    }

    /**
     * 修改数据
     *
     * @param saleOrder 实例对象
     * @return 实例对象
     */
    @Override
    public SaleOrder update(SaleOrder saleOrder) {
        this.saleOrderDao.update(saleOrder);
        return this.queryById(saleOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleOrderDao.deleteById(id) > 0;
    }
}
