package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.Client;
import com.woniuxy.salesmanage.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商户(Client)表控制层
 *
 * @author Noby
 * @since 2022-08-28 15:39:28
 */
@RestController
@RequestMapping("client")
@Slf4j
public class ClientController {
    /**
     * 服务对象
     */
    @Resource
    private ClientService clientService;

    /**
     * 分页查询
     *
     * @param client 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<Client>> queryByPage(@RequestBody Client client, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> client = {}, page = {}, size = {}", client, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.clientService.queryByPage(client, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Client> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.clientService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param client 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Client> add(@RequestBody Client client) {
        log.info("add ===> client = {}", client);
        return ResponseEntity.ok(this.clientService.insert(client));
    }

    /**
     * 编辑数据
     *
     * @param client 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Client> edit(@RequestBody Client client) {
        log.info("edit ===> client = {}", client);
        return ResponseEntity.ok(this.clientService.update(client));
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
        return ResponseEntity.ok(this.clientService.deleteById(id));
    }

}

