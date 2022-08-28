package com.woniuxy.salesmanage.controller;

import com.woniuxy.commonentity.entity.Model;
import com.woniuxy.commonentity.entity.SaleCart;
import com.woniuxy.commonentity.entity.SaleCartItem;
import com.woniuxy.salesmanage.openFeign.ModelFeign;
import com.woniuxy.salesmanage.service.SaleCartItemService;
import com.woniuxy.salesmanage.service.SaleCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 出售购入车条目(SaleCartItem)表控制层
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@RestController
@RequestMapping("saleCartItem")
@Slf4j
public class SaleCartItemController {
    /**
     * 服务对象
     */
    @Resource
    private SaleCartItemService saleCartItemService;

    @Resource
    private SaleCartService saleCartService;

    @Resource
    private ModelFeign modelFeign;

    /**
     * 分页查询
     *
     * @param saleCartItem 筛选条件
     * @param page         当前页
     * @param size         页大小
     * @return 查询结果
     */
    @GetMapping("{page}/{size}")
    public ResponseEntity<Page<SaleCartItem>> queryByPage(@RequestBody SaleCartItem saleCartItem, @PathVariable("page") int page, @PathVariable("size") int size) {
        log.info("queryByPage ===> saleCartItem = {}, page = {}, size = {}", saleCartItem, page, size);
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(this.saleCartItemService.queryByPage(saleCartItem, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SaleCartItem> queryById(@PathVariable("id") Integer id) {
        log.info("queryById ===> id = {}", id);
        return ResponseEntity.ok(this.saleCartItemService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param saleCartItem 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SaleCartItem> add(@RequestBody SaleCartItem saleCartItem) {
        log.info("add ===> saleCartItem = {}", saleCartItem);
        Integer modelId = saleCartItem.getModelId();
        Model model = modelFeign.queryById(modelId).getBody();
        if (model == null) {
            log.error("没有该型号配件");
            return new ResponseEntity("没有该型号配件", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //该配件型号存在
        saleCartItem.setModel(model);
        saleCartItem.setSalePrice(model.getSalePrice());
        Integer totalNum = model.getNum();
        Integer needNum = saleCartItem.getNum();
        if (needNum > totalNum) {
            log.error("仓库数量不足");
            return new ResponseEntity("仓库数量不足", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //该配件型号仓库数量充足
        SaleCartItem insert = saleCartItemService.insert(saleCartItem);
        SaleCart saleCart = saleCartService.queryById(saleCartItem.getSaleCartId());
        Double oldPrice = saleCart.getTotalPrice();
        Double newPrice = needNum * model.getSalePrice();
        saleCart.setTotalPrice(oldPrice + newPrice);
        saleCartService.update(saleCart);

        return ResponseEntity.ok(insert);
    }

    /**
     * 编辑数据
     *
     * @param saleCartItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SaleCartItem> edit(@RequestBody SaleCartItem saleCartItem) {
        log.info("edit ===> saleCartItem = {}", saleCartItem);
        return ResponseEntity.ok(this.saleCartItemService.update(saleCartItem));
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
        return ResponseEntity.ok(this.saleCartItemService.deleteById(id));
    }

}

