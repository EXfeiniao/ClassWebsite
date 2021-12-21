package com.blog.dao;

import com.blog.pojo.Blog;
import com.blog.pojo.BlogAndTag;
import com.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    User getUser(Long id);  //后台展示用户

    User getDetailedUser(@Param("id") Long id);

    List<User> getAllUser();

    List<User> getAboutUser();  //关于页展示

    int saveUser(User user);

    int updateBlog(User user);

    int deleteBlog(Long id);


    User queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
