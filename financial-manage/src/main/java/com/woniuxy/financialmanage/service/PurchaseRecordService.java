package com.woniuxy.financialmanage.service;

import com.woniuxy.commonentity.entity.PurchaseRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 采购记录(PurchaseRecord)表服务接口
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
public interface PurchaseRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PurchaseRecord queryById(Integer id);

    /**
     * 分页查询
     *
     * @param purchaseRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<PurchaseRecord> queryByPage(PurchaseRecord purchaseRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param purchaseRecord 实例对象
     * @return 实例对象
     */
    PurchaseRecord insert(PurchaseRecord purchaseRecord);

    /**
     * 修改数据
     *
     * @param purchaseRecord 实例对象
     * @return 实例对象
     */
    PurchaseRecord update(PurchaseRecord purchaseRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
