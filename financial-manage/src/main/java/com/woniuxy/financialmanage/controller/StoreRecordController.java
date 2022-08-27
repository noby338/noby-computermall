package com.woniuxy.financialmanage.controller;

import com.woniuxy.commonentity.entity.StoreRecord;
import com.woniuxy.financialmanage.service.StoreRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 出库入库记录(StoreRecord)表控制层
 *
 * @author Noby
 * @since 2022-08-27 23:38:38
 */
@RestController
@RequestMapping("storeRecord")
@Slf4j
public class StoreRecordController {
    /**
     * 服务对象
     */
    @Resource
    private StoreRecordService storeRecordService;

    /**
     * 分页查询
     *
     * @param storeRecord 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<StoreRecord>> queryByPage(@RequestBody StoreRecord storeRecord, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> storeRecord = {}, page = {}, size = {}", storeRecord, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.storeRecordService.queryByPage(storeRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<StoreRecord> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.storeRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param storeRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<StoreRecord> add(@RequestBody StoreRecord storeRecord) {
        log.info("add ===> storeRecord = {}", storeRecord);
        return ResponseEntity.ok(this.storeRecordService.insert(storeRecord));
    }

    /**
     * 编辑数据
     *
     * @param storeRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<StoreRecord> edit(@RequestBody StoreRecord storeRecord) {
        log.info("edit ===> storeRecord = {}", storeRecord);
        return ResponseEntity.ok(this.storeRecordService.update(storeRecord));
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
        return ResponseEntity.ok(this.storeRecordService.deleteById(id));
    }

}

