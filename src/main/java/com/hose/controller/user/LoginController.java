package com.hose.controller.user;


import com.hose.pojo.User;
import com.hose.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

//登录
@Controller
public class LoginController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping({"/"})
    public String index(HttpSession session){
        return "user/login";
    }

    //进行注册
    @PostMapping("/register/ok")
    public String registerok(User user,
                             Model model)
    {

        User user1 = userService.AccountingCheck(user.getUserAccountName());

        if(user1 ==null)
        {
            userService.insert(user);

            return "user/login";
        }

        model.addAttribute("msg","账号已被注册！！！");

        return "user/register";
    }

    //跳转注册页面
    @GetMapping("/register")
    public String register()
    {
        return "user/register";
    }
}
