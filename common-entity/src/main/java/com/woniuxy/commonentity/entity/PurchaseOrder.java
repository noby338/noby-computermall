package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 采购订单(PurchaseOrder)实体类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = -38846547962852728L;
    private Integer id;    
    private Integer clientId;    
    private Integer phoneNum;    
    private Integer address;    
    private Double totalMoney;    
    private Integer status;//1：未付款；2：已付款；3：已发货；4：已收货    

}

