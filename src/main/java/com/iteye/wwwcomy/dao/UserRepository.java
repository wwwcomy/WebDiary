package com.iteye.wwwcomy.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iteye.wwwcomy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
}
