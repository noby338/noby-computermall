package com.woniuxy.cooperationmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 供应商(Supplier)实体类
 *
 * @author Noby
 * @since 2022-08-26 22:03:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier implements Serializable {
    private static final long serialVersionUID = -20740149325155445L;
    private Integer id;    
    private String name;    
    private Integer componentsId;

    private Components components;

}

