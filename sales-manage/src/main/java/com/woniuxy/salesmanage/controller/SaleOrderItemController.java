package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.SaleOrderItem;
import com.woniuxy.salesmanage.service.SaleOrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单条目表(SaleOrderItem)表控制层
 *
 * @author Noby
 * @since 2022-08-29 01:23:50
 */
@RestController
@RequestMapping("saleOrderItem")
@Slf4j
public class SaleOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private SaleOrderItemService saleOrderItemService;

    /**
     * 分页查询
     *
     * @param saleOrderItem 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<SaleOrderItem>> queryByPage(@RequestBody SaleOrderItem saleOrderItem, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> saleOrderItem = {}, page = {}, size = {}", saleOrderItem, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.saleOrderItemService.queryByPage(saleOrderItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SaleOrderItem> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.saleOrderItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param saleOrderItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SaleOrderItem> add(@RequestBody SaleOrderItem saleOrderItem) {
        log.info("add ===> saleOrderItem = {}", saleOrderItem);
        return ResponseEntity.ok(this.saleOrderItemService.insert(saleOrderItem));
    }

    /**
     * 编辑数据
     *
     * @param saleOrderItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SaleOrderItem> edit(@RequestBody SaleOrderItem saleOrderItem) {
        log.info("edit ===> saleOrderItem = {}", saleOrderItem);
        return ResponseEntity.ok(this.saleOrderItemService.update(saleOrderItem));
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
        return ResponseEntity.ok(this.saleOrderItemService.deleteById(id));
    }

}

