package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 采购订单条目(PurchaseOrderItem)实体类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrderItem implements Serializable {
    private static final long serialVersionUID = 294265756593081601L;
    private Integer id;    
    private Integer purchaseOrderId;    
    private Integer modelId;    
    private Integer num;    

}

