package com.hose.controller.user;

import com.hose.pojo.User;
import com.hose.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

//更改密码
@Controller
public class ChangePasswordController {
    @Autowired
    UserServiceImpl userService;

    //进行更改密码
    @PostMapping("changepassword/ok")
    public String updatepassword(String oldPwd
            , String newPwd,
                                 HttpSession session
            , Model model)
    {
        User user = (User) session.getAttribute("user");



        System.out.println(user);

        if(user.getUserPassword().equals(oldPwd))
        {
            user.setUserPassword(newPwd);
            System.out.println(user);
            session.setAttribute("user",user);

            userService.updateByPrimaryKey(user);

            return "user/welcome";
        }

        model.addAttribute("msg","原密码错误!!!");

        return "user/changepassword";
    }
}
