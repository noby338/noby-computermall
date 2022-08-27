package com.woniuxy.financialmanage.service.impl;

import com.woniuxy.commonentity.entity.ClientAddress;
import com.woniuxy.financialmanage.dao.ClientAddressDao;
import com.woniuxy.financialmanage.service.ClientAddressService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 商户的收货地址(ClientAddress)表服务实现类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Service("clientAddressService")
public class ClientAddressServiceImpl implements ClientAddressService {
    @Resource
    private ClientAddressDao clientAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ClientAddress queryById(Integer id) {
        return this.clientAddressDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param clientAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ClientAddress> queryByPage(ClientAddress clientAddress, PageRequest pageRequest) {
        long total = this.clientAddressDao.count(clientAddress);
        return new PageImpl<>(this.clientAddressDao.queryAllByLimit(clientAddress, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param clientAddress 实例对象
     * @return 实例对象
     */
    @Override
    public ClientAddress insert(ClientAddress clientAddress) {
        this.clientAddressDao.insert(clientAddress);
        return clientAddress;
    }

    /**
     * 修改数据
     *
     * @param clientAddress 实例对象
     * @return 实例对象
     */
    @Override
    public ClientAddress update(ClientAddress clientAddress) {
        this.clientAddressDao.update(clientAddress);
        return this.queryById(clientAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.clientAddressDao.deleteById(id) > 0;
    }
}
