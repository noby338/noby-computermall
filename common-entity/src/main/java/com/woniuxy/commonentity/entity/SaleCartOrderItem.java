package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 出售购入车条目(SaleCartOrderItem)实体类
 *
 * @author Noby
 * @since 2022-08-29 15:48:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleCartOrderItem implements Serializable {
    private static final long serialVersionUID = 645317892218902212L;
    private Integer id;
    private Integer num;
    private Double salePrice;//出售价格
    private Integer modelId;
    private Integer saleCartId;
    private Integer saleOrderId;

    private Model model;
    private SaleCart saleCart;
    private SaleOrder saleOrder;

}

