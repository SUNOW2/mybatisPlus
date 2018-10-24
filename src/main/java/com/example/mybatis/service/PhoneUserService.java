package com.example.mybatis.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mybatis.entity.PhoneUser;
import com.example.mybatis.mapper.PhoneUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @ClassName PhoneUserService
 * @Author 徐旭
 * @Date 2018/10/9 16:13
 * @Version 1.0
 */
@Service
public class PhoneUserService extends ServiceImpl<PhoneUserMapper, PhoneUser> {

    @Autowired
    PhoneUserMapper mapper;

    public List<PhoneUser> selectList() {
        List<String> array = new ArrayList<>();
        array.add("id");

        List<PhoneUser> list = mapper.selectList(
                new EntityWrapper<PhoneUser>()
                        .where("password", "123")
//                        .eq("password", "123")
                        .or("password=123456")
//                        .andNew("id={0}", "1")
                        .like("phone_number", "1316")
//                        .groupBy("password")
                        .orderDesc(array)
        );
        return list;
    }

}
