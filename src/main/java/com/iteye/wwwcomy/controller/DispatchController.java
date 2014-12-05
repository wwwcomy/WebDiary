package com.iteye.wwwcomy.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.iteye.wwwcomy.model.User;

@Controller
@SessionAttributes("loginUser")
public class DispatchController {
    /**
     * 登录提交页面
     * 
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, ModelAndView view) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreated_date(new Date(System.currentTimeMillis()));
        view.addObject("loginUser", user);
        view.setViewName("redirect:main.jsp");
        return view;
    }
}
