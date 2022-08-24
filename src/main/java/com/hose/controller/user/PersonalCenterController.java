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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
//个人中心
@Controller
public class PersonalCenterController {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    HouseServiceImpl houseService;
    @Autowired
    OrderServiceImpl orderService;

    //欢迎页面
    @GetMapping("/admin/welcome")
    public String welcome()
    {
        return "user/welcome";
    }

    //更改密码页面
    @GetMapping("/changepassword")
    public String changepasswordPage()
    {
        return "user/changepassword";
    }

    //退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");

        return "user/login";
    }

    //我的房源页面
    @GetMapping("/Myhousing")
    public String Myhousing(Model model
                        , HttpSession session,
                            @RequestParam(value = "userId",required = false) String userId) throws IOException {
        User user ;

        if(userId==null)
        {
            user = (User) session.getAttribute("user");
        }else
        {
            model.addAttribute("ifadmin",1);
            user=userService.selectByPrimaryKey(Integer.valueOf(userId));
        }

        int i = houseService.MyHouses(user.getUserId());
        model.addAttribute("HouseNumber",i);

        List<House> houses = houseService.selectMyHouses(user.getUserId());



        for(House he:houses)
        {
            PublicMethod.picturestorage(session, he);
        }

        model.addAttribute("houses",houses);

        return "user/Myhousing";
    }

    //添加房源页面
    @GetMapping("/addHouse")
    public String addHousePage()
    {
            return "user/addHouse";
    }

    //添加房源
    @PostMapping("addHouse/ok")
    public String addHouse(
                MultipartFile houseImage1
            , House house
            ,HttpSession session
    ) throws IOException {

        String filename = UUID.randomUUID().toString()+houseImage1.getOriginalFilename();
        ServletContext servletContext = session.getServletContext();
        String path = servletContext.getRealPath("temporaryfiles");

        File file = new File(path);

        if(!file.exists())
        {
            file.mkdir();
        }

        String finalPath=path +File.separator+filename;

        byte[] bytes = houseImage1.getBytes();
        house.setHouseImage(bytes);
        house.setHouseImageName(filename);
        house.setHouseTime(new Date());
        User user = (User) session.getAttribute("user");
        house.setUserId(user.getUserId());


        houseService.insert(house);

        houseImage1.transferTo(new File(finalPath));

        return "user/Myhousing";

    }

    //我的收藏页面
    @GetMapping("/myselect")
    public String myselect(HttpSession session,
                           Model model) throws IOException {


        User user = (User) session.getAttribute("user");


            String hoppingtrolley = user.getUserShoppingtrolley();

        model.addAttribute("HouseNumber",0);

            if(hoppingtrolley!=null )
            {

                if(hoppingtrolley.equals(""))
                {
                    return "user/myselect";
                }

                String[] split = hoppingtrolley.split(",");

                model.addAttribute("HouseNumber",split.length);

                List<House> houses = new ArrayList<>();
                for (String s : split) {
                    House house1 = houseService.selectByPrimaryKey(Integer.valueOf(s));

                    houses.add(house1);

                    PublicMethod.picturestorage(session,house1);
                }
                model.addAttribute("houses", houses);
            }

        return "user/myselect";
    }

    //我的订单页面
    @GetMapping("/myorder")
    public String myorder(HttpSession session,
                          Model model) throws IOException {
        User user = (User) session.getAttribute("user");

        List<Order> orders = orderService.selectAllByUserId(user.getUserId());

        ServletContext servletContext = session.getServletContext();
        String path = servletContext.getRealPath("temporaryfiles");



        List<House> houses=new ArrayList<>();
        for (Order o:orders)
        {
            House house = houseService.selectByPrimaryKey(o.getHouseId());
            houses.add(house);

            PublicMethod.picturestorage(session, house);

        }
        if (houses.isEmpty())
        {
            model.addAttribute("HouseNumber",0);
        }else
        {
            model.addAttribute("houses",houses);
        }

        return "user/myorder";
    }

    //删除房子
    @GetMapping("/deleteHouse")
    public String deleteHouse(String houseId)
    {
        houseService.deleteByPrimaryKey(Integer.valueOf(houseId));

        return "redirect:/Myhousing";
    }
}
