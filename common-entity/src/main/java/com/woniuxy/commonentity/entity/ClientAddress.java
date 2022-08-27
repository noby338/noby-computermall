package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商户的收货地址(ClientAddress)实体类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientAddress implements Serializable {
    private static final long serialVersionUID = -52561168157853002L;
    private Integer id;    
    private String address;    
    private Integer clientId;    

}

