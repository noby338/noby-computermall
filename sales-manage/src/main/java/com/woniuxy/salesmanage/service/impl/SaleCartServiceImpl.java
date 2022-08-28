package com.woniuxy.salesmanage.service.impl;

import com.woniuxy.commonentity.entity.SaleCart;
import com.woniuxy.salesmanage.dao.SaleCartDao;
import com.woniuxy.salesmanage.service.SaleCartService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 销售购物车(SaleCart)表服务实现类
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@Service("saleCartService")
public class SaleCartServiceImpl implements SaleCartService {
    @Resource
    private SaleCartDao saleCartDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SaleCart queryById(Integer id) {
        return this.saleCartDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param saleCart 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SaleCart> queryByPage(SaleCart saleCart, PageRequest pageRequest) {
        long total = this.saleCartDao.count(saleCart);
        return new PageImpl<>(this.saleCartDao.queryAllByLimit(saleCart, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param saleCart 实例对象
     * @return 实例对象
     */
    @Override
    public SaleCart insert(SaleCart saleCart) {
        this.saleCartDao.insert(saleCart);
        return saleCart;
    }

    /**
     * 修改数据
     *
     * @param saleCart 实例对象
     * @return 实例对象
     */
    @Override
    public SaleCart update(SaleCart saleCart) {
        this.saleCartDao.update(saleCart);
        return this.queryById(saleCart.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.saleCartDao.deleteById(id) > 0;
    }
}
