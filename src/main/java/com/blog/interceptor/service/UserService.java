package com.blog.interceptor.service;

import com.blog.pojo.Blog;
import com.blog.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    User getUser(Long id);  //后台展示用户

    User getDetailedUser(Long id);

    List<User> getAllUser();

    List<User> getAboutUser();  //关于页展示

    int saveUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);


    public User checkUser(String username, String password);
}
