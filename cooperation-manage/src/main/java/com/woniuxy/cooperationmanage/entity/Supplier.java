package com.woniuxy.cooperationmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 供应商(Supplier)实体类
 *
 * @author Noby
 * @since 2022-08-27 19:43:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier implements Serializable {
    private static final long serialVersionUID = -63407130366758839L;
    private Integer id;    
    private String name;    
    private Integer componentsId;    

}

