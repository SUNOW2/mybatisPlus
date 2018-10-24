package com.example.mybatis.provider;

import com.example.mybatis.entity.PhoneUser;

/**
 * 描述：
 *
 * @ClassName PhoneUserProvider
 * @Author 徐旭
 * @Date 2018/10/16 22:13
 * @Version 1.0
 */
public class PhoneUserProvider {

    public String select(PhoneUser user) {
        StringBuffer sql = new StringBuffer("SELECT * FROM mybatis_plus WHERE 1 = 1");
        if (user.getPassword() != null) {
            sql.append(" AND password = #{password}");
        }
        return sql.toString();
    }
}
