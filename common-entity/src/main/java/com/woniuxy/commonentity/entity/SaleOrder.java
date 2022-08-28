package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 出售订单(SaleOrder)实体类
 *
 * @author Noby
 * @since 2022-08-28 15:39:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrder implements Serializable {
    private static final long serialVersionUID = -59790555007733403L;
    private Integer id;
    private String phoneNum;
    private String address;
    private Integer status;//1：已下单；2：已付款；3：已发货；4：已收货
    private Integer clientId;
    private Double totalPrice;

    private Client client;
    private List<SaleRecord> saleRecordList;

}

