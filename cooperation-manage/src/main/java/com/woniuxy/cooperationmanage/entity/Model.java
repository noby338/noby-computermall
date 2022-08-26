package com.woniuxy.cooperationmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 各配件型号(Model)实体类
 *
 * @author Noby
 * @since 2022-08-26 23:20:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model implements Serializable {
    private static final long serialVersionUID = -29563458987855608L;
    private Integer id;    
    private String name;    
    private Integer supplierId;    
    private Double price;    
    private Integer states;//1：正常；2：缺货；

    private Supplier supplier;

}

