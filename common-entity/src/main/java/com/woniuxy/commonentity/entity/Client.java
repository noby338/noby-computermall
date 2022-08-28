package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 商户(Client)实体类
 *
 * @author Noby
 * @since 2022-08-28 15:39:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    private static final long serialVersionUID = -54601777502154114L;
    private Integer id;
    private String name;
    private String phoneNum;

    private List<ClientAddress> clientAddressList;
    private List<SaleOrder> saleOrderList;

}

