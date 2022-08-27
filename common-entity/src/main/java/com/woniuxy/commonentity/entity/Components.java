package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 各电脑配件(Components)实体类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Components implements Serializable {
    private static final long serialVersionUID = -97727086277365233L;
    private Integer id;    
    private String name;    

}

