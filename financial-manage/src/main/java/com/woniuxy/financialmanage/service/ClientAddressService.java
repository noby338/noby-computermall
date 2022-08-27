package com.woniuxy.financialmanage.service;

import com.woniuxy.commonentity.entity.ClientAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 商户的收货地址(ClientAddress)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface ClientAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClientAddress queryById(Integer id);

    /**
     * 分页查询
     *
     * @param clientAddress 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ClientAddress> queryByPage(ClientAddress clientAddress, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param clientAddress 实例对象
     * @return 实例对象
     */
    ClientAddress insert(ClientAddress clientAddress);

    /**
     * 修改数据
     *
     * @param clientAddress 实例对象
     * @return 实例对象
     */
    ClientAddress update(ClientAddress clientAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
