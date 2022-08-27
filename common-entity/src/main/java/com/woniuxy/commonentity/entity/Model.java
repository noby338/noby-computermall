package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 各配件型号(Model)实体类
 *
 * @author Noby
 * @since 2022-08-28 00:00:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model implements Serializable {
    private static final long serialVersionUID = -72113836287439879L;
    private Integer id;
    private String name;
    private Integer supplierId;
    private Integer storeId;
    private Integer num;//剩余数量
    private Double purchasePrice;//进货价格
    private Double salePrice;//出售价格

    private Supplier supplier;
    private Store store;

}

