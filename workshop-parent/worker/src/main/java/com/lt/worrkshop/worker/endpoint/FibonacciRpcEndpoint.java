package com.lt.worrkshop.worker.endpoint;

import org.apache.servicecomb.provider.pojo.RpcSchema;
import org.springframework.beans.factory.annotation.Autowired;

import com.lt.worrkshop.worker.service.FibonacciEndpoint;
import com.lt.worrkshop.worker.service.FibonacciService;

@RpcSchema(schemaId = "fibonacciRpcEndpoint")
public class FibonacciRpcEndpoint implements FibonacciEndpoint {

	private final FibonacciService fibonacciService;

	@Autowired
	public FibonacciRpcEndpoint(FibonacciService fibonacciService) {
		this.fibonacciService = fibonacciService;
	}

	@Override
	public long term(int n) {
		return fibonacciService.term(n);
	}

	@Override
	public String sayHello(String name) {
		return fibonacciService.sayHello(name);
	}
}