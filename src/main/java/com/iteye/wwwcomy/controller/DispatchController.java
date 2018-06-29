package com.iteye.wwwcomy.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iteye.wwwcomy.model.User;
import com.iteye.wwwcomy.model.dto.AuthenticationResponse;
import com.iteye.wwwcomy.service.impl.UserServiceImpl;

@RestController
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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AuthenticationResponse login(String username, String password) {
		User user = userService.loadUser(username, password);
		if (user == null) {
			return new AuthenticationResponse(false);
		} else {
			return new AuthenticationResponse(true);
		}
	}
}
