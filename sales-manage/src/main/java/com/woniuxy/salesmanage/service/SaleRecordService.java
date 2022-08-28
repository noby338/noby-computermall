package com.woniuxy.salesmanage.service;

import com.woniuxy.commonentity.entity.SaleRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 出售记录(SaleRecord)表服务接口
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
public interface SaleRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SaleRecord queryById(Integer id);

    /**
     * 分页查询
     *
     * @param saleRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SaleRecord> queryByPage(SaleRecord saleRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param saleRecord 实例对象
     * @return 实例对象
     */
    SaleRecord insert(SaleRecord saleRecord);

    /**
     * 修改数据
     *
     * @param saleRecord 实例对象
     * @return 实例对象
     */
    SaleRecord update(SaleRecord saleRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
