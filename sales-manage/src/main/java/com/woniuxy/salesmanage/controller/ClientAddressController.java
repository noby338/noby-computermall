package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.ClientAddress;
import com.woniuxy.salesmanage.service.ClientAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商户的收货地址(ClientAddress)表控制层
 *
 * @author Noby
 * @since 2022-08-28 15:39:28
 */
@RestController
@RequestMapping("clientAddress")
@Slf4j
public class ClientAddressController {
    /**
     * 服务对象
     */
    @Resource
    private ClientAddressService clientAddressService;

    /**
     * 分页查询
     *
     * @param clientAddress 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<ClientAddress>> queryByPage(@RequestBody ClientAddress clientAddress, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> clientAddress = {}, page = {}, size = {}", clientAddress, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.clientAddressService.queryByPage(clientAddress, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ClientAddress> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.clientAddressService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param clientAddress 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ClientAddress> add(@RequestBody ClientAddress clientAddress) {
        log.info("add ===> clientAddress = {}", clientAddress);
        return ResponseEntity.ok(this.clientAddressService.insert(clientAddress));
    }

    /**
     * 编辑数据
     *
     * @param clientAddress 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ClientAddress> edit(@RequestBody ClientAddress clientAddress) {
        log.info("edit ===> clientAddress = {}", clientAddress);
        return ResponseEntity.ok(this.clientAddressService.update(clientAddress));
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
        return ResponseEntity.ok(this.clientAddressService.deleteById(id));
    }

}

