package com.woniuxy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author Noby
 * @since 2022-08-26 20:24:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 159384601439438029L;
    private Integer id;    
    private String name;    
    private Integer age;    
    private Integer gender;    

}

