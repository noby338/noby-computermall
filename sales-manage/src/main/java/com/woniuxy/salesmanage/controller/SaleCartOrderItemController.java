package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.Model;
import com.woniuxy.commonentity.entity.SaleCart;
import com.woniuxy.commonentity.entity.SaleCartOrderItem;
import com.woniuxy.salesmanage.openFeign.CooperationFeign;
import com.woniuxy.salesmanage.service.SaleCartOrderItemService;
import com.woniuxy.salesmanage.service.SaleCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 出售购入车条目(SaleCartOrderItem)表控制层
 *
 * @author Noby
 * @since 2022-08-29 15:48:26
 */
@RestController
@RequestMapping("saleCartOrderItem")
@Slf4j
public class SaleCartOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private SaleCartOrderItemService saleCartOrderItemService;

    @Resource
    private SaleCartService saleCartService;

    @Resource
    private CooperationFeign cooperationFeign;


    /**
     * 分页查询
     *
     * @param saleCartOrderItem 筛选条件
     * @param page 当前页
     * @param size 页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<SaleCartOrderItem>> queryByPage(@RequestBody SaleCartOrderItem saleCartOrderItem, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> saleCartOrderItem = {}, page = {}, size = {}", saleCartOrderItem, page, size);
        PageRequest pageRequest = PageRequest.of(page,size);
        return ResponseEntity.ok(this.saleCartOrderItemService.queryByPage(saleCartOrderItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SaleCartOrderItem> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.saleCartOrderItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param saleCartOrderItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SaleCartOrderItem> add(@RequestBody SaleCartOrderItem saleCartOrderItem) {
        log.info("add ===> saleCartOrderItem = {}", saleCartOrderItem);
        //该购物车是否存在
        if (saleCartService.queryById(saleCartOrderItem.getSaleCartId()) == null) {
            return new ResponseEntity("该购物车不存在", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //该配件型号是否存在
        Integer modelId = saleCartOrderItem.getModelId();
        Model model = cooperationFeign.modelQueryById(modelId).getBody();
        if (model == null) {
            return new ResponseEntity("没有该型号配件", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //该配件型号仓库数量是否充足
        saleCartOrderItem.setModel(model);
        saleCartOrderItem.setSalePrice(model.getSalePrice());
        Integer totalNum = model.getNum();
        Integer needNum = saleCartOrderItem.getNum();
        if (needNum > totalNum) {
            return new ResponseEntity("仓库数量不足", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //添加购物车条目，更改购物车金额
        SaleCartOrderItem insert = saleCartOrderItemService.insert(saleCartOrderItem);
        SaleCart saleCart = saleCartService.queryById(saleCartOrderItem.getSaleCartId());
        Double oldPrice = saleCart.getTotalPrice();
        Double newPrice = needNum * model.getSalePrice();
        saleCart.setTotalPrice(oldPrice + newPrice);
        saleCartService.update(saleCart);

        return ResponseEntity.ok(insert);
    }

    /**
     * 编辑数据
     *
     * @param saleCartOrderItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SaleCartOrderItem> edit(@RequestBody SaleCartOrderItem saleCartOrderItem) {
        log.info("edit ===> saleCartOrderItem = {}", saleCartOrderItem);
        return ResponseEntity.ok(this.saleCartOrderItemService.update(saleCartOrderItem));
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
        return ResponseEntity.ok(this.saleCartOrderItemService.deleteById(id));
    }

}

