package com.woniuxy.financialmanage.service.impl;

import com.woniuxy.commonentity.entity.PurchaseOrderItem;
import com.woniuxy.financialmanage.dao.PurchaseOrderItemDao;
import com.woniuxy.financialmanage.service.PurchaseOrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 采购订单条目(PurchaseOrderItem)表服务实现类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Service("purchaseOrderItemService")
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {
    @Resource
    private PurchaseOrderItemDao purchaseOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PurchaseOrderItem queryById(Integer id) {
        return this.purchaseOrderItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param purchaseOrderItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<PurchaseOrderItem> queryByPage(PurchaseOrderItem purchaseOrderItem, PageRequest pageRequest) {
        long total = this.purchaseOrderItemDao.count(purchaseOrderItem);
        return new PageImpl<>(this.purchaseOrderItemDao.queryAllByLimit(purchaseOrderItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param purchaseOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseOrderItem insert(PurchaseOrderItem purchaseOrderItem) {
        this.purchaseOrderItemDao.insert(purchaseOrderItem);
        return purchaseOrderItem;
    }

    /**
     * 修改数据
     *
     * @param purchaseOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public PurchaseOrderItem update(PurchaseOrderItem purchaseOrderItem) {
        this.purchaseOrderItemDao.update(purchaseOrderItem);
        return this.queryById(purchaseOrderItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.purchaseOrderItemDao.deleteById(id) > 0;
    }
}
