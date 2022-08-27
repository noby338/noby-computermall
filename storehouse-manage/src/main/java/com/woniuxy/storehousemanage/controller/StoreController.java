package com.woniuxy.storehousemanage.controller;

import com.woniuxy.commonentity.entity.Store;
import com.woniuxy.storehousemanage.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 库存(Store)表控制层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@RestController
@RequestMapping("store")
@Slf4j
public class StoreController {
    /**
     * 服务对象
     */
    @Resource
    private StoreService storeService;

    /**
     * 分页查询
     *
     * @param store 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<Store>> queryByPage(@RequestBody Store store, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> store = {}, page = {}, size = {}", store, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.storeService.queryByPage(store, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Store> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.storeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param store 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Store> add(@RequestBody Store store) {
        log.info("add ===> store = {}", store);
        return ResponseEntity.ok(this.storeService.insert(store));
    }

    /**
     * 编辑数据
     *
     * @param store 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Store> edit(@RequestBody Store store) {
        log.info("edit ===> store = {}", store);
        return ResponseEntity.ok(this.storeService.update(store));
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
        return ResponseEntity.ok(this.storeService.deleteById(id));
    }

}

