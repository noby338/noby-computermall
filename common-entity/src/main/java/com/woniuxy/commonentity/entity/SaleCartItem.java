package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 出售购入车条目(SaleCartItem)实体类
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleCartItem implements Serializable {
    private static final long serialVersionUID = -64661527451783705L;
    private Integer id;
    private Integer num;
    private Double salePrice;//出售价格
    private Integer saleOrderId;
    private Integer modelId;
    private Integer saleCartId;

    private SaleOrder saleOrder;
    private Model model;
    private SaleCart saleCart;

}

