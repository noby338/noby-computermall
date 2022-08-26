package com.woniuxy.cooperationmanage.controller;

import com.woniuxy.cooperationmanage.entity.Supplier;
import com.woniuxy.cooperationmanage.service.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 供应商(Supplier)表控制层
 *
 * @author Noby
 * @since 2022-08-26 22:03:12
 */
@RestController
@RequestMapping("supplier")
public class SupplierController {
    /**
     * 服务对象
     */
    @Resource
    private SupplierService supplierService;

    /**
     * 分页查询
     *
     * @param supplier 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<Supplier>> queryByPage(@RequestBody Supplier supplier, @PathVariable("page") int page, @PathVariable("size") int size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.supplierService.queryByPage(supplier, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Supplier> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.supplierService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param supplier 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Supplier> add(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(this.supplierService.insert(supplier));
    }

    /**
     * 编辑数据
     *
     * @param supplier 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Supplier> edit(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(this.supplierService.update(supplier));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.supplierService.deleteById(id));
    }

}

