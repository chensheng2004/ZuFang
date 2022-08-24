package com.hose.controller.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hose.pojo.House;
import com.hose.pojo.PublicMethod;
import com.hose.pojo.User;
import com.hose.service.Impl.HouseServiceImpl;
import com.hose.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//首页
@Controller
public class IndexController {
    @Resource
    UserServiceImpl userService;
    @Autowired
    HouseServiceImpl houseService;

    //进行登录
    @PostMapping("/index")
    public String login(@PathVariable(value = "register",required = false) String register
            ,String userName
            , String userPassword
            , HttpSession session
            , Model model) throws IOException {
        User user = userService.LoginCheck(userName, userPassword);

        if(user!=null)
        {
            session.setAttribute("user",user);
            int i = houseService.HouseNumber();
            model.addAttribute("HouseNumber",i);

            PageHelper.startPage(1,5);
            List<House> houses = houseService.selectAll(user.getUserId());
            if (houses!=null)
            {
                model.addAttribute("houses",houses);
            }

            for(House house:houses)
            {
                PublicMethod.picturestorage(session,house);
            }

            return "user/index";
        }

        model.addAttribute("msg","账号或者密码错误!!!");

        return "user/login";
    }

    //进行登录
    @GetMapping("/index")
    public  String index(
            HttpSession session
            , Model model) throws IOException {


        User user = (User) session.getAttribute("user");

        if(user !=null)
        {
            PageHelper.startPage(1,5);
            List<House> houses = houseService.selectAll(user.getUserId());
            if (houses!=null)
            {
                model.addAttribute("houses",houses);
            }

            for(House house:houses)
            {
                PublicMethod.picturestorage(session,house);
            }


            return "user/index";
        }
        else
            return "user/login";
    }


    //用户中心页面
    @GetMapping("/personalCenter")
    public String personalCenter()
    {
        return "user/personalCenter";
    }

    //房屋搜索页面
    @GetMapping("/Morehouses")
    public  String  Morehouses(@RequestParam(value = "keywords",required = false) String keywords
                               ,@RequestParam(value = "page",required = false,defaultValue = "1") String page
                                ,Model model
                                ,HttpSession session) throws IOException {
        Page<Object> page1 = PageHelper.startPage(Integer.parseInt(page), 5);
        User user = (User) session.getAttribute("user");

        List<House> houses;
        if(keywords==null)
        {
            houses = houseService.selectAll(user.getUserId());
            model.addAttribute("houses",houses);
        }
        else if(keywords.equals("asd2136587q4wes855415qwe5"))
        {
            houses = houseService.PriceAscending(user.getUserId());
            model.addAttribute("houses",houses);
        }
        else if(keywords.equals("1356dfs13f5sd3554fsdfwe85x"))
        {
             houses = houseService.PriceDescending(user.getUserId());
            model.addAttribute("houses",houses);
        }else {
            houses = houseService.searchResult(keywords);
            model.addAttribute("houses",houses);
        }

        for(House house:houses)
        {
            PublicMethod.picturestorage(session,house);
        }

        model.addAttribute("page",page1);

        return "user/Morehouses";
    }
}

