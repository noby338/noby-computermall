package com.woniuxy.cooperationmanage.controller;

import com.woniuxy.commonentity.entity.Components;
import com.woniuxy.cooperationmanage.service.ComponentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 各电脑配件(Components)表控制层
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@RestController
@RequestMapping("components")
@Slf4j
public class ComponentsController {
    /**
     * 服务对象
     */
    @Resource
    private ComponentsService componentsService;

    /**
     * 分页查询
     *
     * @param components 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<Components>> queryByPage(@RequestBody Components components, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> components = {}, page = {}, size = {}", components, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.componentsService.queryByPage(components, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Components> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.componentsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param components 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Components> add(@RequestBody Components components) {
        log.info("add ===> components = {}", components);
        return ResponseEntity.ok(this.componentsService.insert(components));
    }

    /**
     * 编辑数据
     *
     * @param components 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Components> edit(@RequestBody Components components) {
        log.info("edit ===> components = {}", components);
        return ResponseEntity.ok(this.componentsService.update(components));
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
        return ResponseEntity.ok(this.componentsService.deleteById(id));
    }

}

