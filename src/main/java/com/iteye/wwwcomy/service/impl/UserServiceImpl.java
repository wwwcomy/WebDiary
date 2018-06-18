package com.iteye.wwwcomy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteye.wwwcomy.dao.UserRepository;
import com.iteye.wwwcomy.model.User;

@Service
public class UserServiceImpl {
	@Autowired
	private UserRepository userRepository;

	public User loadUser(String userName) {
		return userRepository.findByName(userName);
	}

	public User loadUser(String userName, String password) {
		// TODO this is not right, only for the 1st phase test only. Should consider
		// salt & hash
		return userRepository.findByName(userName);
	}

}
