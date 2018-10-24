package com.example.mybatis.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述：
 *
 * @ClassName PhoneUser
 * @Author 徐旭
 * @Date 2018/10/9 16:05
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("mybatis_plus")
public class PhoneUser extends Model<PhoneUser> {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 联系方式
     */
    @NotEmpty(message = "联系方式不可为空")
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerDate;

    @TableField(exist = false)
    private String remarks;

    private MybatisPlusChild mybatisPlusChild;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
