package com.hose.controller.order;

import com.hose.pojo.Order;
import com.hose.pojo.User;
import com.hose.service.Impl.UserServiceImpl;
import com.hose.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

//订单
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    UserServiceImpl userService;

    //预定房屋
    @PostMapping("/Order")
    public ModelAndView Order(String houseId,
                        HttpSession session,
                        Model model)
    {
        User user = (User) session.getAttribute("user");

        String userShoppingtrolley = user.getUserShoppingtrolley();

        if(userShoppingtrolley!=null)
        {
            String[] split = userShoppingtrolley.split(",");

            if(split.length==1)
            {
                user.setUserShoppingtrolley("");
            }else
            {
                for(String s:split)
                {
                    if(s.equals(houseId))
                    {
                        int i = userShoppingtrolley.indexOf(houseId);

                        String xin="";

                        if(i==0)
                        {
                            String substring = userShoppingtrolley.substring(2);
                            xin=substring;
                        }else
                        {
                            String substring = userShoppingtrolley.substring(0, i - 1);
                            String substring1 = userShoppingtrolley.substring(i + 1);

                            xin=substring+substring1;
                        }


                        user.setUserShoppingtrolley(xin);
                        break;
                    }
                }
            }
        }

        userService.updateByPrimaryKey(user);

        Order o=new Order(Integer.parseInt(houseId),user.getUserId(),new Date());

        orderService.insert(o);

        model.addAttribute("ifreserve",1);

        return  new ModelAndView("redirect:/housesdetail?houseId="+houseId);
    }
}
