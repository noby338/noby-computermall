package com.woniuxy.financialmanage.service.impl;

import com.woniuxy.commonentity.entity.PurchaseOrder;
import com.woniuxy.financialmanage.dao.PurchaseOrderDao;
import com.woniuxy.financialmanage.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 采购订单(PurchaseOrder)表服务实现类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Resource
    private PurchaseOrderDao purchaseOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseOrder queryById(Integer id) {
        return this.purchaseOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param purchaseOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<PurchaseOrder> queryByPage(PurchaseOrder purchaseOrder, PageRequest pageRequest) {
        long total = this.purchaseOrderDao.count(purchaseOrder);
        return new PageImpl<>(this.purchaseOrderDao.queryAllByLimit(purchaseOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseOrder insert(PurchaseOrder purchaseOrder) {
        this.purchaseOrderDao.insert(purchaseOrder);
        return purchaseOrder;
    }

    /**
     * 修改数据
     *
     * @param purchaseOrder 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseOrder update(PurchaseOrder purchaseOrder) {
        this.purchaseOrderDao.update(purchaseOrder);
        return this.queryById(purchaseOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.purchaseOrderDao.deleteById(id) > 0;
    }
}
