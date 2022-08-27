package com.woniuxy.financialmanage.service.impl;

import com.woniuxy.commonentity.entity.Client;
import com.woniuxy.financialmanage.dao.ClientDao;
import com.woniuxy.financialmanage.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 商户(Client)表服务实现类
 *
 * @author Noby
 * @since 2022-08-27 22:13:00
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {
    @Resource
    private ClientDao clientDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Client queryById(Integer id) {
        return this.clientDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param client 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Client> queryByPage(Client client, PageRequest pageRequest) {
        long total = this.clientDao.count(client);
        return new PageImpl<>(this.clientDao.queryAllByLimit(client, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param client 实例对象
     * @return 实例对象
     */
    @Override
    public Client insert(Client client) {
        this.clientDao.insert(client);
        return client;
    }

    /**
     * 修改数据
     *
     * @param client 实例对象
     * @return 实例对象
     */
    @Override
    public Client update(Client client) {
        this.clientDao.update(client);
        return this.queryById(client.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.clientDao.deleteById(id) > 0;
    }
}
