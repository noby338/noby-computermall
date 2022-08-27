package com.woniuxy.commonentity.util;

import java.util.UUID;

/**
 * @Description
 * @Author LittleCode
 * @Date 2022/7/9 15:39
 */
public class GetUUID {
    public static String UUID()
    {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return UUID.randomUUID().toString().replace("-", "");
    }
}
