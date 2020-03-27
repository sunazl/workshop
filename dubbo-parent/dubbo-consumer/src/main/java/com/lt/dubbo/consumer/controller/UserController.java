package com.lt.dubbo.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lt.dubbo.api.User.UserService;

@RestController
public class UserController {
	@Reference
	private UserService userService;
	
	@RequestMapping(value="/addUser")
	public String registerUser(String name) {
		return userService.registerUser(name);
	}
}
