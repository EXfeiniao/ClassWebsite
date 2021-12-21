package com.blog.controller;

import com.blog.interceptor.service.BlogService;
import com.blog.interceptor.service.UserService;
import com.blog.pojo.Blog;
import com.blog.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AboutShowController {

    @Autowired
    private UserService userService;

    @GetMapping("/about")
    public String about(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model){

        PageHelper.startPage(pagenum, 6);
        List<User> allUser = userService.getAllUser();

        //得到分页的结果
        PageInfo pageInfo = new PageInfo(allUser);
        model.addAttribute("pageInfo", pageInfo);
        return "about";
    }



/*    //User详细信息
    @GetMapping("/user/{id}")
    public String toLogin(@PathVariable Long id, Model model){
        User user = userService.getDetailedUser(id);
        model.addAttribute("user", user);
        return "user";
    }*/
}
