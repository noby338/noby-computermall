package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 出售购入车条目(SaleCartItem)实体类
 *
 * @author Noby
 * @since 2022-08-28 22:45:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleCartItem implements Serializable {
    private static final long serialVersionUID = 808473584913598392L;
    private Integer id;
    private Integer num;
    private Double salePrice;//出售价格
    private Integer modelId;
    private Integer saleCartId;

    private Model model;
    private SaleCart saleCart;

}

