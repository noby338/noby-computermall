package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 订单条目表(SaleOrderItem)实体类
 *
 * @author Noby
 * @since 2022-08-29 01:23:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrderItem implements Serializable {
    private static final long serialVersionUID = 122313725267027017L;
    private Integer id;
    private Integer num;
    private Integer saleOrderId;
    private Integer modelId;
    private Double salePrice;

}

