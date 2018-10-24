package com.example.mybatis.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 描述：
 *
 * @ClassName MybatisPlusChild
 * @Author 徐旭
 * @Date 2018/10/16 21:23
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mybatis_plus_child")
public class MybatisPlusChild extends Model<MybatisPlusChild> {
    /**
     * 编号
     */
    private Long id;

    /**
     * mybatis_plus的编号
     */
    private Long mybatisPlusId;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}

