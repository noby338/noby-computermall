package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.SaleRecord;
import com.woniuxy.salesmanage.service.SaleRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 出售记录(SaleRecord)表控制层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@RestController
@RequestMapping("saleRecord")
@Slf4j
public class SaleRecordController {
    /**
     * 服务对象
     */
    @Resource
    private SaleRecordService saleRecordService;

    /**
     * 分页查询
     *
     * @param saleRecord 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<SaleRecord>> queryByPage(@RequestBody SaleRecord saleRecord, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> saleRecord = {}, page = {}, size = {}", saleRecord, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.saleRecordService.queryByPage(saleRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SaleRecord> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.saleRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param saleRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SaleRecord> add(@RequestBody SaleRecord saleRecord) {
        log.info("add ===> saleRecord = {}", saleRecord);
        return ResponseEntity.ok(this.saleRecordService.insert(saleRecord));
    }

    /**
     * 编辑数据
     *
     * @param saleRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SaleRecord> edit(@RequestBody SaleRecord saleRecord) {
        log.info("edit ===> saleRecord = {}", saleRecord);
        return ResponseEntity.ok(this.saleRecordService.update(saleRecord));
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
        return ResponseEntity.ok(this.saleRecordService.deleteById(id));
    }

}

