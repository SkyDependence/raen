package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Article {
    // 标题
    private String title;

    // 正文
    private String text;

    // 用户
    private Integer id;

    // 分类
    private Integer category;

    // 点赞数
    private Integer likes;


}
