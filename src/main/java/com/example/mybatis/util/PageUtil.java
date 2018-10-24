package com.example.mybatis.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述：
 *
 * @ClassName PageUtil
 * @Author 徐旭
 * @Date 2018/10/10 10:29
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtil {
    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页大小
     */
    private int pageSize;
}
