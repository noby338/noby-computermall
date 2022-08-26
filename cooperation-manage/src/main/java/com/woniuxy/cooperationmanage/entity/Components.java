package com.woniuxy.cooperationmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Components)实体类
 *
 * @author Noby
 * @since 2022-08-26 21:53:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Components implements Serializable {
    private static final long serialVersionUID = 783835980956729880L;
    private Integer id;    
    private String name;    

}

