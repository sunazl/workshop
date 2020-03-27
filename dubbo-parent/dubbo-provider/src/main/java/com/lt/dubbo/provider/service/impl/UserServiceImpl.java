package com.lt.dubbo.provider.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.lt.dubbo.api.User.UserService;
@Service
@Component
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public String registerUser(String name) {
		logger.debug("provider 注册的用户为：%s",name+"先生");
		return " 注册的用户为："+name;
	}

}
