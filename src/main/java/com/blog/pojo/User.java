package com.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Integer type;   //0 1 2 分别表示 老师 班委 普通学生
    private Date birthday;
    private Date updateTime;
    private Integer sex;
    private String content;
    private Long age;


    private List<Blog> blogs = new ArrayList<>();
}
