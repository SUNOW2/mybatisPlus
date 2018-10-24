package com.example.mybatis.controller;

import com.example.mybatis.entity.PhoneUser;
import com.example.mybatis.service.PhoneUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @ClassName CacheController
 * @Author 徐旭
 * @Date 2018/10/10 14:49
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/cache")
public class CacheController {

    @Autowired
    PhoneUserService phoneUserService;

    /**
     * key为参数，sync=true表示同步，多个请求会被阻塞
     */
    @RequestMapping(value = "/listCustomers", method = {RequestMethod.GET, RequestMethod.POST})
    @Cacheable(value = "listCustomers", sync = true)
    public List<PhoneUser> list() {
        List<PhoneUser> list = new ArrayList<>();
        list = phoneUserService.selectList();
        return list;
    }
}
