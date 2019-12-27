package com.lt.worrkshop.worker.service.impl;

import org.springframework.stereotype.Service;

import com.lt.worrkshop.worker.service.FibonacciService;

@Service
class FibonacciServiceImpl implements FibonacciService {
	
	@Override
	public long term(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		return term(n - 1) + term(n - 2);
	}

	@Override
	public String sayHello(String name) {
		return "Hello~ " + name;
	}
}
