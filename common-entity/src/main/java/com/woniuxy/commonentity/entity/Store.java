package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 库存(Store)实体类
 *
 * @author Noby
 * @since 2022-08-27 22:13:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {
    private static final long serialVersionUID = -48830608225858180L;
    private Integer id;    
    private Integer componentsId;    
    private String address;    
    private Integer num;    
    private Integer totalCapacity;

    private Components components;

    private List<Model> modelList;

}

