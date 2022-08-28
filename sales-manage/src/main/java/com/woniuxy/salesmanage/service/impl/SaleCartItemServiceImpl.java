package com.woniuxy.salesmanage.service.impl;

import com.woniuxy.commonentity.entity.SaleCartItem;
import com.woniuxy.salesmanage.dao.SaleCartItemDao;
import com.woniuxy.salesmanage.service.SaleCartItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 出售购入车条目(SaleCartItem)表服务实现类
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@Service("saleCartItemService")
@Slf4j
public class SaleCartItemServiceImpl implements SaleCartItemService {
    @Resource
    private SaleCartItemDao saleCartItemDao;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SaleCartItem queryById(Integer id) {
        return this.saleCartItemDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param saleCartItem 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SaleCartItem> queryByPage(SaleCartItem saleCartItem, PageRequest pageRequest) {
        long total = this.saleCartItemDao.count(saleCartItem);
        return new PageImpl<>(this.saleCartItemDao.queryAllByLimit(saleCartItem, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param saleCartItem 实例对象
     * @return 实例对象
     */
    @Override
    public SaleCartItem insert(SaleCartItem saleCartItem) {
        this.saleCartItemDao.insert(saleCartItem);
        return saleCartItem;
    }

    /**
     * 修改数据
     *
     * @param saleCartItem 实例对象
     * @return 实例对象
     */
    @Override
    public SaleCartItem update(SaleCartItem saleCartItem) {
        this.saleCartItemDao.update(saleCartItem);
        return this.queryById(saleCartItem.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleCartItemDao.deleteById(id) > 0;
    }
}
