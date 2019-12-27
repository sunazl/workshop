package com.lt.worrkshop.worker.service.impl;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.MediaType;


import com.lt.worrkshop.worker.service.UserService;
import com.lt.worrkshop.worker.vo.User;
@RestSchema(schemaId = "userservice")
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserServiceImpl implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	@RequestMapping(path = "/addUser", method = RequestMethod.GET)
	public String addUser(String userid, String userName, String password) {
		User u = new User(userid,userName,password);
		logger.info("userid: "+userid+",userName: "+userName+",password: "+password);
		return u.toString();
	}

}
