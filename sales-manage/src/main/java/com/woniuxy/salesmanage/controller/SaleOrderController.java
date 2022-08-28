package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.*;
import com.woniuxy.salesmanage.service.ClientAddressService;
import com.woniuxy.salesmanage.service.ClientService;
import com.woniuxy.salesmanage.service.SaleCartService;
import com.woniuxy.salesmanage.service.SaleOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private SaleCartService saleCartService;

    @Resource
    private ClientAddressService clientAddressService;

    @Resource
    private ClientService clientService;


    /**
     * 添加订单
     *
     * @return 单条数据
     */
    @GetMapping("placeOrder/{clientId}")
    public ResponseEntity<SaleOrder> placeOrder(@PathVariable("clientId") int clientId) {
        log.info("placeOrder ===> clientId = {}",clientId);
        SaleOrder saleOrder = new SaleOrder();
        Client client = clientService.queryById(clientId);

        saleOrder.setPhoneNum(client.getPhoneNum());
        List<ClientAddress> clientAddressList = client.getClientAddressList();
        for (ClientAddress clientAddress : clientAddressList) {
            if (clientAddress.getIsDefault() == 1) {
                saleOrder.setAddress(clientAddress.getAddress());
            }
        }
        saleOrder.setTotalPrice(client.getSaleCart().getTotalPrice());
        saleOrder.setStatus(1);
        saleOrder.setClientId(clientId);
        return ResponseEntity.ok(saleOrderService.insert(saleOrder));
    }

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

