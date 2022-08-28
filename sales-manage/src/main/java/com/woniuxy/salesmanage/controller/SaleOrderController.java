package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.SaleOrder;
import com.woniuxy.salesmanage.service.SaleOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 出售订单(SaleOrder)表控制层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@RestController
@RequestMapping("saleOrder")
@Slf4j
public class SaleOrderController {
    /**
     * 服务对象
     */
    @Resource
    private SaleOrderService saleOrderService;

    /**
     * 分页查询
     *
     * @param saleOrder 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<SaleOrder>> queryByPage(@RequestBody SaleOrder saleOrder, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> saleOrder = {}, page = {}, size = {}", saleOrder, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.saleOrderService.queryByPage(saleOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SaleOrder> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.saleOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param saleOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SaleOrder> add(@RequestBody SaleOrder saleOrder) {
        log.info("add ===> saleOrder = {}", saleOrder);
        return ResponseEntity.ok(this.saleOrderService.insert(saleOrder));
    }

    /**
     * 编辑数据
     *
     * @param saleOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SaleOrder> edit(@RequestBody SaleOrder saleOrder) {
        log.info("edit ===> saleOrder = {}", saleOrder);
        return ResponseEntity.ok(this.saleOrderService.update(saleOrder));
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
        return ResponseEntity.ok(this.saleOrderService.deleteById(id));
    }

}

