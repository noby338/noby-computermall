package com.woniuxy.financialmanage.controller;

import com.woniuxy.commonentity.entity.PurchaseOrderItem;
import com.woniuxy.financialmanage.service.PurchaseOrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 采购订单条目(PurchaseOrderItem)表控制层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@RestController
@RequestMapping("purchaseOrderItem")
@Slf4j
public class PurchaseOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseOrderItemService purchaseOrderItemService;

    /**
     * 分页查询
     *
     * @param purchaseOrderItem 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<PurchaseOrderItem>> queryByPage(@RequestBody PurchaseOrderItem purchaseOrderItem, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> purchaseOrderItem = {}, page = {}, size = {}", purchaseOrderItem, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.purchaseOrderItemService.queryByPage(purchaseOrderItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<PurchaseOrderItem> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.purchaseOrderItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param purchaseOrderItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<PurchaseOrderItem> add(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        log.info("add ===> purchaseOrderItem = {}", purchaseOrderItem);
        return ResponseEntity.ok(this.purchaseOrderItemService.insert(purchaseOrderItem));
    }

    /**
     * 编辑数据
     *
     * @param purchaseOrderItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<PurchaseOrderItem> edit(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        log.info("edit ===> purchaseOrderItem = {}", purchaseOrderItem);
        return ResponseEntity.ok(this.purchaseOrderItemService.update(purchaseOrderItem));
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
        return ResponseEntity.ok(this.purchaseOrderItemService.deleteById(id));
    }

}

