package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 采购记录(PurchaseRecord)实体类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRecord implements Serializable {
    private static final long serialVersionUID = 564523797778742622L;
    private Integer id;    
    private Integer purchaseOrderId;    
    private Date dateTime;    

}

