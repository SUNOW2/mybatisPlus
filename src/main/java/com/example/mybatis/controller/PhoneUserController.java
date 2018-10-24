package com.example.mybatis.controller;

import com.example.mybatis.entity.PhoneUser;
import com.example.mybatis.mapper.PhoneUserMapper;
import com.example.mybatis.service.PhoneUserService;
import com.example.mybatis.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @ClassName PhoneUserController
 * @Author 徐旭
 * @Date 2018/10/9 16:42
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class PhoneUserController {

    @Autowired
    PhoneUserService phoneUserService;

    @Autowired
    PhoneUserMapper mapper;

    /**
     * 不分页查询记录
     *
     * @return
     */
    @RequestMapping(value = "/selectList", method = {RequestMethod.GET, RequestMethod.POST})
    public List<PhoneUser> selectList() {
        return phoneUserService.selectList();
    }

    /**
     * 新增记录
     *
     * @param user
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.GET, RequestMethod.POST})
    public void insert(@RequestBody @Valid PhoneUser user) {
        user.setRegisterDate(LocalDateTime.now());

        phoneUserService.insert(user);
    }

    /**
     * 删除记录
     *
     * @param id
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public void delete(String id) {
        phoneUserService.deleteById(Long.valueOf(id));
    }

    /**
     * 更新记录
     *
     * @param user
     */
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    public void update(PhoneUser user) {
        phoneUserService.updateById(user);
    }

    /**
     * 分页查询数据，结合PageHelper插件
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/selectByPage", method = {RequestMethod.GET, RequestMethod.POST})
    public PageInfo<PhoneUser> selectByPage(@RequestBody PageUtil page) {
        List<PhoneUser> list = new ArrayList<>();

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        list = phoneUserService.selectList();

        PageInfo<PhoneUser> pageInfo = new PageInfo(list);

        return pageInfo;
    }

    /**
     * 根据id批量查询
     *
     * @param idLists
     * @return
     */
    @RequestMapping(value = "/selectBatchIds", method = {RequestMethod.GET, RequestMethod.POST})
    public List<PhoneUser> selectBatchIds(@RequestBody ArrayList<String> idLists) {
        return phoneUserService.selectBatchIds(idLists);
    }

    @RequestMapping(value = "/mapSelect")
    public List<PhoneUser> getList() {
        return mapper.getList();
    }

    @RequestMapping(value = "/providerSelect")
    public List<PhoneUser> getChild() {
        PhoneUser user = new PhoneUser();
        user.setPhoneNumber("13160022063");
        user.setPassword("123456");

        return mapper.getListBySqlProvider(user);
    }

    @RequestMapping(value = "/updateBatch")
    public int updateBatch() {

        List<PhoneUser> list = new ArrayList<>();
        PhoneUser user1 = new PhoneUser();
        user1.setId(1L)
                .setPassword("12345")
                .setPhoneNumber("13160022064")
                .setRegisterDate(LocalDateTime.now());

        PhoneUser user2 = new PhoneUser();
        user2.setId(3L)
                .setPhoneNumber("13160022000")
                .setPassword("123")
                .setRegisterDate(LocalDateTime.now());

        list.add(user1);
        list.add(user2);

        System.out.println(list);

        return mapper.updateBatchById(list);
    }
}
