package com.example.mybatis.util;

import java.util.UUID;

/**
 * @author rick
 */
public class UUIDUtil {

    /**
     * 自动生成32位的UUid，对应数据库的主键id进行插入用。
     * @return uuid
     */

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
