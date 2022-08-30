package com.woniuxy.salesmanage.openFeign;

import com.woniuxy.commonentity.entity.Model;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 各配件型号(Model)FeignClient
 *
 * @author Noby
 * @since 2022-08-27 23:58:24
 */
@FeignClient(value = "cooperation-manage")
public interface CooperationFeign {

    /**
     * 编辑数据
     *
     * @param model 实体
     * @return 编辑结果
     */
    @PutMapping("model")
    ResponseEntity<Model> modelEdit(@RequestBody Model model);

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("model/{id}")
    ResponseEntity<Model> modelQueryById(@PathVariable("id") Integer id);

}

