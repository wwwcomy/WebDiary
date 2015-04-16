package com.iteye.wwwcomy.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.service.impl.UserServiceImpl;

@Controller
@SessionAttributes("loginUser")
public class DispatchController {
    @Resource
    private UserServiceImpl userService;

    /**
     * 登录提交页面
     * 
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ModelAndView login(String username, String password, ModelAndView view) {
        User user = userService.loadUser(username, password);
        if (user == null) {
            view.addObject("success", "false");
        } else {
            view.addObject("loginUser", user);
            view.setViewName("redirect:main.jsp");
        }
        return view;
    }
}
