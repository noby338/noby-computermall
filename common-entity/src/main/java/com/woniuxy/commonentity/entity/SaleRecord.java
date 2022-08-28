package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 出售记录(SaleRecord)实体类
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleRecord implements Serializable {
    private static final long serialVersionUID = 261734088916797612L;
    private Integer id;
    private Date dateTime;
    private Integer saleOrderId;
    private Integer recordType;//记录种类(1：下单；2：付款；3：发货；4：收货；5：退货；6：退款)

    private SaleOrder saleOrder;
}

