package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商户(Client)实体类
 *
 * @author Noby
 * @since 2022-08-27 22:13:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    private static final long serialVersionUID = 696336100491945263L;
    private Integer id;    
    private String name;    
    private String phoneNum;    
    private String defaultAddress;    

}

