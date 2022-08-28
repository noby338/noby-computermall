package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.SaleCart;
import com.woniuxy.salesmanage.service.SaleCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 销售购物车(SaleCart)表控制层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@RestController
@RequestMapping("saleCart")
@Slf4j
public class SaleCartController {
    /**
     * 服务对象
     */
    @Resource
    private SaleCartService saleCartService;

    /**
     * 分页查询
     *
     * @param saleCart 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<SaleCart>> queryByPage(@RequestBody SaleCart saleCart, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> saleCart = {}, page = {}, size = {}", saleCart, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.saleCartService.queryByPage(saleCart, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SaleCart> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.saleCartService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param saleCart 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SaleCart> add(@RequestBody SaleCart saleCart) {
        log.info("add ===> saleCart = {}", saleCart);
        return ResponseEntity.ok(this.saleCartService.insert(saleCart));
    }

    /**
     * 编辑数据
     *
     * @param saleCart 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SaleCart> edit(@RequestBody SaleCart saleCart) {
        log.info("edit ===> saleCart = {}", saleCart);
        return ResponseEntity.ok(this.saleCartService.update(saleCart));
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
        return ResponseEntity.ok(this.saleCartService.deleteById(id));
    }

}

