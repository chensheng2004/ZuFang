package com.hose.controller.admin;

import com.hose.pojo.*;
import com.hose.service.Impl.AdminServiceImpl;
import com.hose.service.Impl.HouseServiceImpl;
import com.hose.service.Impl.OrderServiceImpl;
import com.hose.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminLoginController {

    @Autowired
    AdminServiceImpl adminService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    HouseServiceImpl houseService;

    //管理员页面
    @GetMapping("/admin")
    public String admin()
    {

        return "admin/login";
    }

    //登录
    @PostMapping("/admin/login")
    public String login(Admin admin,
                        Model model,
                        HttpSession session)
    {
        User user=new User();
        user.setUserAccountName("123");
        user.setUserPassword("123");

        session.setAttribute("admin",user);

        Admin admin1 = adminService.selectAdmin(admin.getAccountName(), admin.getPassword());

        if(admin1 !=null)
        {
            session.setAttribute("Admin",admin1);
            return "admin/home";
        }

        model.addAttribute("msg","账号或者密码错误");

        return "admin/login";
    }

    //退出登录
    @GetMapping("/admin/logout")
    public String adminlogiout(HttpSession session)
    {
        session.removeAttribute("user");

        return "admin/login";
    }

    //所有用户页面
    @GetMapping("/admin/allusers")
    public String allusers(Model model)
    {
        List<User> users = userService.selectAll();

        List<UserandOrderandHoser> uoh=new ArrayList<>();
        if(users.size()!=0)
        {
            for(User u:users)
            {
                UserandOrderandHoser uaoah=new UserandOrderandHoser();
                List<Order> orders = orderService.selectAllByUserId(u.getUserId());
                List<House> houses = houseService.selectMyHouses(u.getUserId());

                uaoah.setOrdersize(orders.size());
                uaoah.setHousesize(houses.size());
                uaoah.setUser(u);

                uoh.add(uaoah);
            }

            model.addAttribute("uoh",uoh);
        }else{
            model.addAttribute("users",0);
        }

        return "admin/allusers";
    }

    //查看订单页面
    @GetMapping("/admin/order")
    public String adminorder(String userId,
                             Model model)
    {
        List<Order> orders = orderService.selectAllByUserId(Integer.valueOf(userId));

        if(orders.size()==0)
            model.addAttribute("orders",0);
        else
        model.addAttribute("orders",orders);

        return "admin/order";
    }

    //编辑用户页面
    @GetMapping("/admin/editUser")
    public String admineditUser(String userId,
                                Model model)
    {
        User user = userService.selectByPrimaryKey(Integer.valueOf(userId));

        model.addAttribute("admineditUser",user);

        return "admin/editUser";
    }

    //编辑用户
    @PostMapping("/admin/editUser/ok")
    public String admineditUserok(User user)
    {
        User user1 = userService.selectByPrimaryKey(user.getUserId());

        user.setUserShoppingtrolley(user1.getUserShoppingtrolley());
        userService.updateByPrimaryKey(user);

        return "user/welcome";
    }

    //删除用户
    @GetMapping("/admin/delete")
    public  String admindelete(String userId)
    {
        userService.deleteByPrimaryKey(Integer.valueOf(userId));

        return "user/welcome";
    }
}
