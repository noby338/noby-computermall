package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 销售购物车(SaleCart)实体类
 *
 * @author Noby
 * @since 2022-08-28 22:47:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleCart implements Serializable {
    private static final long serialVersionUID = -74799860711412603L;
    private Integer id;
    private Double totalPrice;
    private Integer clientId;

    private Client client;
    private List<SaleCartItem> saleCartItemList;
}

