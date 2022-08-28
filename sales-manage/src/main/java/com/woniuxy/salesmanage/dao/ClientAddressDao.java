package com.woniuxy.salesmanage.dao;

import com.woniuxy.commonentity.entity.ClientAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 商户的收货地址(ClientAddress)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-28 15:39:28
 */
public interface ClientAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClientAddress queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param clientAddress 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ClientAddress> queryAllByLimit(@Param("clientAddress") ClientAddress clientAddress, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param clientAddress 查询条件
     * @return 总行数
     */
    long count(ClientAddress clientAddress);

    /**
     * 新增数据
     *
     * @param clientAddress 实例对象
     * @return 影响行数
     */
    int insert(ClientAddress clientAddress);

    /**
     * 修改数据
     *
     * @param clientAddress 实例对象
     * @return 影响行数
     */
    int update(ClientAddress clientAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

