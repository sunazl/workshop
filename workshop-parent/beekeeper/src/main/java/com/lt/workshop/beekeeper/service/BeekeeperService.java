package com.lt.workshop.beekeeper.service;

import com.lt.workshop.beekeeper.vo.User;

public interface BeekeeperService {

	long ancestorsOfDroneAt(int generation);

	long ancestorsOfQueenAt(int generation);
	
	String sayHello(String name);
	
	String addUser(String id,String userName,String password);
}
