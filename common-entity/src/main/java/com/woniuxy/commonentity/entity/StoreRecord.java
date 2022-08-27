package com.woniuxy.commonentity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 出库入库记录(StoreRecord)实体类
 *
 * @author Noby
 * @since 2022-08-27 23:38:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreRecord implements Serializable {
    private static final long serialVersionUID = 536317856937383244L;
    private Integer id;    
    private Integer num;    
    private Date dateTime;    
    private Integer storeId;    
    private Integer modelId;    

    private Store store;
    private Model model;
}

