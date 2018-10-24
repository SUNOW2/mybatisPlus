package com.example.mybatis.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.mybatis.entity.MybatisPlusChild;
import com.example.mybatis.entity.PhoneUser;
import com.example.mybatis.provider.PhoneUserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：
 *
 * @ClassName PhoneUserMapper
 * @Author 徐旭
 * @Date 2018/10/9 16:12
 * @Version 1.0
 */
@Repository
public interface PhoneUserMapper extends BaseMapper<PhoneUser> {

    /**
     * 获取mybatis_plus的联系方式列表@Many的用法和@One类似，如下
     * many = @Many(select = "com.example.mybatis.mapper.PhoneUserMapper.getChildList")
     *
     * @return 联系方式列表
     */
    @Select("SELECT * FROM mybatis_plus")
    @Results(id = "mybatisPlusMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "mybatisPlusChild",
                    one = @One(select = "com.example.mybatis.mapper.PhoneUserMapper.getChild")),
            @Result(column = "phone_number", property = "phoneNumber")
    })
    List<PhoneUser> getList();

    /**
     * 获取mybatis_plus_child的记录
     *
     * @param id mybatis_plus_id
     * @return
     */
    @Select("SELECT * FROM mybatis_plus_child WHERE 1=1 AND mybatis_plus_id=#{id}")
    MybatisPlusChild getChild(@Param("id") Long id);

    /**
     * 此处使用sqlProvider实现查询
     *
     * @param user
     * @return 查询结果
     */
    @SelectProvider(type = PhoneUserProvider.class, method = "select")
    @ResultMap(value = "mybatisPlusMap")
    List<PhoneUser> getListBySqlProvider(PhoneUser user);

    /**
     * 批量更新
     *
     * @return 是否成功，1，代表成功
     */
    @Update({"<script>",
            "<foreach item='item' index='key' collection='list' separator=';'>" +
                    "UPDATE mybatis_plus SET " +
                    "phone_number=#{item.phoneNumber}," +
                    "password=#{item.password}," +
                    "register_date=#{item.registerDate}" +
                    " WHERE 1=1 AND id=#{item.id}" +
                    "</foreach>",
            "</script>"})
    int updateBatchById(@Param("list") List<PhoneUser> list);

    /**
     * 批量删除
     * @param list id列表
     * @return 删除结果
     */
    @Delete({"<script>",
            "DELETE FROM archive_classify WHERE id OR parent_id in(" +
                    "<foreach collection='list' item='item' separator=','>" +
                    "#{item}" +
                    "</foreach>)" +
                    "</script>"})
    int deleteBatchByClassifyIds(@Param("list") List<String> list);

}
