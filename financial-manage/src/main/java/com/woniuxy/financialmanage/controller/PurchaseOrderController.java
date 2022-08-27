package com.woniuxy.financialmanage.controller;

import com.woniuxy.commonentity.entity.PurchaseOrder;
import com.woniuxy.financialmanage.service.PurchaseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 采购订单(PurchaseOrder)表控制层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@RestController
@RequestMapping("purchaseOrder")
@Slf4j
public class PurchaseOrderController {
    /**
     * 服务对象
     */
    @Resource
    private PurchaseOrderService purchaseOrderService;

    /**
     * 分页查询
     *
     * @param purchaseOrder 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<PurchaseOrder>> queryByPage(@RequestBody PurchaseOrder purchaseOrder, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> purchaseOrder = {}, page = {}, size = {}", purchaseOrder, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.purchaseOrderService.queryByPage(purchaseOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<PurchaseOrder> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.purchaseOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param purchaseOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<PurchaseOrder> add(@RequestBody PurchaseOrder purchaseOrder) {
        log.info("add ===> purchaseOrder = {}", purchaseOrder);
        return ResponseEntity.ok(this.purchaseOrderService.insert(purchaseOrder));
    }

    /**
     * 编辑数据
     *
     * @param purchaseOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<PurchaseOrder> edit(@RequestBody PurchaseOrder purchaseOrder) {
        log.info("edit ===> purchaseOrder = {}", purchaseOrder);
        return ResponseEntity.ok(this.purchaseOrderService.update(purchaseOrder));
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
        return ResponseEntity.ok(this.purchaseOrderService.deleteById(id));
    }

}

