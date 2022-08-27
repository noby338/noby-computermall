package com.woniuxy.financialmanage.controller;

import com.woniuxy.commonentity.entity.PurchaseRecord;
import com.woniuxy.financialmanage.service.PurchaseRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 采购记录(PurchaseRecord)表控制层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@RestController
@RequestMapping("purchaseRecord")
@Slf4j
public class PurchaseRecordController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseRecordService purchaseRecordService;

    /**
     * 分页查询
     *
     * @param purchaseRecord 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<PurchaseRecord>> queryByPage(@RequestBody PurchaseRecord purchaseRecord, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> purchaseRecord = {}, page = {}, size = {}", purchaseRecord, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.purchaseRecordService.queryByPage(purchaseRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<PurchaseRecord> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.purchaseRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param purchaseRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<PurchaseRecord> add(@RequestBody PurchaseRecord purchaseRecord) {
        log.info("add ===> purchaseRecord = {}", purchaseRecord);
        return ResponseEntity.ok(this.purchaseRecordService.insert(purchaseRecord));
    }

    /**
     * 编辑数据
     *
     * @param purchaseRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<PurchaseRecord> edit(@RequestBody PurchaseRecord purchaseRecord) {
        log.info("edit ===> purchaseRecord = {}", purchaseRecord);
        return ResponseEntity.ok(this.purchaseRecordService.update(purchaseRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        log.info("deleteById ===> id = {}", id);
        return ResponseEntity.ok(this.purchaseRecordService.deleteById(id));
    }

}

