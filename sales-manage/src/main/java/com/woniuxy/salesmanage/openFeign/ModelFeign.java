package com.woniuxy.salesmanage.openFeign;

import com.woniuxy.commonentity.entity.Model;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 各配件型号(Model)FeignClient
 *
 * @author Noby
 * @since 2022-08-27 23:58:24
 */
@FeignClient(value = "cooperation-manage")
@RequestMapping("model")
public interface ModelFeign {
    /**
     * 分页查询
     *
     * @param model 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    ResponseEntity<Page<Model>> queryByPage(@RequestBody Model model, @PathVariable("page") int page, @PathVariable("size") int size);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    ResponseEntity<Model> queryById(@PathVariable("id") Integer id);

    /**
     * 新增数据
     *
     * @param model 实体
     * @return 新增结果
     */
    @PostMapping
    ResponseEntity<Model> add(@RequestBody Model model);

    /**
     * 编辑数据
     *
     * @param model 实体
     * @return 编辑结果
     */
    @PutMapping
    ResponseEntity<Model> edit(@RequestBody Model model);

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("{id}")
    ResponseEntity<Boolean> deleteById(@PathVariable("id") Integer id);

}

