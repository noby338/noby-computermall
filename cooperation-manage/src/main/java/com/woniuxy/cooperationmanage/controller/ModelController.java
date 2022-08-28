package com.woniuxy.cooperationmanage.controller;

import com.woniuxy.commonentity.entity.Model;
import com.woniuxy.cooperationmanage.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 各配件型号(Model)表控制层
 *
 * @author Noby
 * @since 2022-08-27 23:58:24
 */
@RestController
@RequestMapping("model")
@Slf4j
public class ModelController {
    /**
     * 服务对象
     */
    @Resource
    private ModelService modelService;

    /**
     * 分页查询
     *
     * @param model 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<Model>> queryByPage(@RequestBody Model model, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> model = {}, page = {}, size = {}", model, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.modelService.queryByPage(model, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Model> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.modelService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param model 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Model> add(@RequestBody Model model) {
        log.info("add ===> model = {}", model);
        return ResponseEntity.ok(this.modelService.insert(model));
    }

    /**
     * 编辑数据
     *
     * @param model 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Model> edit(@RequestBody Model model) {
        log.info("edit ===> model = {}", model);
        return ResponseEntity.ok(this.modelService.update(model));
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
        return ResponseEntity.ok(this.modelService.deleteById(id));
    }

}

