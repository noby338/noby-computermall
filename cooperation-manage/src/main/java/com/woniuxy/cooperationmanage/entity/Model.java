package com.woniuxy.cooperationmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 各配件型号(Model)实体类
 *
 * @author Noby
 * @since 2022-08-27 19:43:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model implements Serializable {
    private static final long serialVersionUID = -64010202072309978L;
    private Integer id;    
    private String name;    
    private Integer supplierId;    
    private Double price;    
    private Integer states;//1：正常；2：缺货；    

}

