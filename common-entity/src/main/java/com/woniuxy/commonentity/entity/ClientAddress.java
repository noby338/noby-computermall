package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商户的收货地址(ClientAddress)实体类
 *
 * @author Noby
 * @since 2022-08-28 15:39:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientAddress implements Serializable {
    private static final long serialVersionUID = 126311432241526474L;
    private Integer id;
    private String address;
    private Integer clientId;
    private Integer isDefault;//是否为默认地址

    private Client client;

}

