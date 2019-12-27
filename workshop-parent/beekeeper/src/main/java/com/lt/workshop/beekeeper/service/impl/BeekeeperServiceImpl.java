package com.lt.workshop.beekeeper.service.impl;

import com.lt.workshop.beekeeper.service.BeekeeperService;
import com.lt.workshop.beekeeper.service.FibonacciCalculator;
import com.lt.workshop.beekeeper.service.UserService;
import com.lt.workshop.beekeeper.vo.User;

public class BeekeeperServiceImpl implements BeekeeperService {

	private final FibonacciCalculator fibonacciCalculator;
	private final UserService userService;
	public BeekeeperServiceImpl(FibonacciCalculator fibonacciCalculator,UserService userService) {
		this.fibonacciCalculator = fibonacciCalculator;
		this.userService = userService;
	}

	@Override
	public long ancestorsOfDroneAt(int generation) {
		if (generation <= 0) {
			return 0;
		}
		return fibonacciCalculator.term(generation + 1);
	}

	@Override
	public long ancestorsOfQueenAt(int generation) {
		if (generation <= 0) {
			return 0;
		}
		return fibonacciCalculator.term(generation + 2);
	}

	@Override
	public String sayHello(String name) {
		return fibonacciCalculator.sayHello(name);
	}

	@Override
	public String addUser(String id, String userName, String password) {
		
		return userService.addUser(id, userName, password);
	}
	
}
