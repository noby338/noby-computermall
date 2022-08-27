package com.woniuxy.cooperationmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 各电脑配件(Components)实体类
 *
 * @author Noby
 * @since 2022-08-27 19:46:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Components implements Serializable {
    private static final long serialVersionUID = -27961667478700833L;
    private Integer id;    
    private String name;    

}

