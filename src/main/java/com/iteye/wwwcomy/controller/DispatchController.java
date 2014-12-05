package com.iteye.wwwcomy.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iteye.wwwcomy.model.User;

@Controller
public class DispatchController {
    /**
     * 登录提交页面
     * 
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreated_date(new Date(System.currentTimeMillis()));
        model.addAttribute("loginUser", user);
        return "main";
    }
}
