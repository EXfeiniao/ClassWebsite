package com.blog.interceptor.service.impl;

import com.blog.dao.UserDao;
import com.blog.exception.NotFoundException;
import com.blog.interceptor.service.UserService;
import com.blog.pojo.Blog;
import com.blog.pojo.User;
import com.blog.util.MD5Utils;
import com.blog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public User getUser(Long id){
        return userDao.getUser(id);
    }

    @Override
    public User getDetailedUser(Long id) {
        User user = userDao.getDetailedUser(id);
        if (user == null) {
            throw new NotFoundException("该学生不存在");
        }
        String content = user.getContent();
        user.setContent(MarkdownUtils.markdownToHtmlExtensions(content));  //将Markdown格式转换成html
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public List<User> getAboutUser() {
        return null;
    }

    @Override
    public int saveUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }


    @Override
    public User checkUser(String username, String password) {
        User user = userDao.queryByUsernameAndPassword(username, MD5Utils.code(password)); //md5加密
        return user;
    }
}
