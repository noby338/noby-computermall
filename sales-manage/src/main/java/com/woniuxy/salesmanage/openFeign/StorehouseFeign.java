package com.woniuxy.salesmanage.openFeign;

import com.woniuxy.commonentity.entity.Store;
import com.woniuxy.commonentity.entity.StoreRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 出库入库记录(StoreRecord)FeignClient
 *
 * @author Noby
 * @since 2022-08-27 23:38:38
 */
@FeignClient(value = "storehouse-manage")
public interface StorehouseFeign {

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/storeRecord/{id}")
    ResponseEntity<StoreRecord> storeRecordQueryById(@PathVariable("id") Integer id);

    /**
     * 新增数据
     *
     * @param storeRecord 实体
     * @return 新增结果
     */
    @PostMapping("/storeRecord")
    ResponseEntity<StoreRecord> storeRecordAdd(@RequestBody StoreRecord storeRecord);

    /**
     * 编辑数据
     *
     * @param store 实体
     * @return 编辑结果
     */
    @PutMapping("/store")
    ResponseEntity<Store> storeEdit(@RequestBody Store store);
}

