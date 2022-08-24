package com.hose.controller.user;

import com.hose.pojo.House;
import com.hose.pojo.Order;
import com.hose.pojo.PublicMethod;
import com.hose.pojo.User;
import com.hose.service.Impl.HouseServiceImpl;
import com.hose.service.Impl.OrderServiceImpl;
import com.hose.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

//房屋
@Controller
public class HousesdetailController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    HouseServiceImpl houseService;
    @Autowired
    OrderServiceImpl orderService;

    //进入房屋详细页面
    @GetMapping("/housesdetail")
    public String housesdetail(@RequestParam("houseId")String houseId,
                               Model model,
                               HttpSession session) throws IOException {


        User admin = (User) session.getAttribute("admin");
        model.addAttribute("ifadmin",0);

        if(admin == null)
        {
            User user = (User) session.getAttribute("user");

            model.addAttribute("judge",0);

            String hoppingtrolley = user.getUserShoppingtrolley();

            if(hoppingtrolley !=null)
            {
                String[] split = hoppingtrolley.split(",");

                for (String s:split)
                {
                    if(s.equals(houseId)){
                        model.addAttribute("judge",1);
                        break;
                    }
                }
            }

            Order order = orderService.selectspecifying(Integer.valueOf(houseId), user.getUserId());
            if(order!=null)
            {
                model.addAttribute("ifreserve",1);
            }else
            {
                model.addAttribute("ifreserve",0);
            }

        }else {
            model.addAttribute("ifadmin",1);
        }




        House house = houseService.selectByPrimaryKey(Integer.parseInt(houseId));



        model.addAttribute("house",house);

        PublicMethod.picturestorage(session, house);


        return "user/housesdetail";
    }



    //点击收藏
    @PostMapping("/Collect")
    public  ModelAndView Collect(String houseId,
                            HttpSession session,
                           Model model)
    {
        User user = (User) session.getAttribute("user");

        String userShoppingtrolley = user.getUserShoppingtrolley();

        if(userShoppingtrolley == null || userShoppingtrolley.equals(""))
        {
            user.setUserShoppingtrolley(houseId);
        }else {
            userShoppingtrolley =userShoppingtrolley +","+houseId;
            user.setUserShoppingtrolley(userShoppingtrolley);
        }


        userService.updateByPrimaryKey(user);

        model.addAttribute("judge",1);

        Order order = orderService.selectspecifying(Integer.valueOf(houseId), user.getUserId());
        if(order!=null)
        {
            model.addAttribute("ifreserve",1);
        }else
        {
            model.addAttribute("ifreserve",0);
        }

        return  new ModelAndView("redirect:/housesdetail?houseId="+houseId);
    }
}
