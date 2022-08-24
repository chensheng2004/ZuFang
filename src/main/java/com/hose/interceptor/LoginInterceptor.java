package com.hose.interceptor;

import com.hose.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        User admin = (User) session.getAttribute("admin");

        if(user !=null ||admin !=null)
        {
            return true;
        }

        request.setAttribute("msg","请先登录！！！");

        request.getRequestDispatcher("/").forward(request,response);

        return false;
    }
}
