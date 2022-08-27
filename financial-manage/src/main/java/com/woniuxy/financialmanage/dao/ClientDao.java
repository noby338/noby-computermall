package com.woniuxy.financialmanage.dao;

import com.woniuxy.commonentity.entity.Client;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 商户(Client)表数据库访问层
 *
 * @author Noby
 * @since 2022-08-27 22:13:00
 */
public interface ClientDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Client queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param client 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Client> queryAllByLimit(@Param("client") Client client, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param client 查询条件
     * @return 总行数
     */
    long count(Client client);

    /**
     * 新增数据
     *
     * @param client 实例对象
     * @return 影响行数
     */
    int insert(Client client);

    /**
     * 修改数据
     *
     * @param client 实例对象
     * @return 影响行数
     */
    int update(Client client);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

