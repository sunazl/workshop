package com.lt.worrkshop.worker.endpoint;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lt.worrkshop.worker.service.FibonacciEndpoint;
import com.lt.worrkshop.worker.service.FibonacciService;

@RestSchema(schemaId = "fibonacciRestEndpoint")
@RequestMapping("/fibonacci")
@Controller
public class FibonacciRestEndpoint implements FibonacciEndpoint {

	private final FibonacciService fibonacciService;

	@Autowired
	FibonacciRestEndpoint(FibonacciService fibonacciService) {
		this.fibonacciService = fibonacciService;
	}

	@Override
	@RequestMapping(value = "/term", method = RequestMethod.GET)
	@ResponseBody
	public long term(int n) {
		return fibonacciService.term(n);
	}

	@Override
	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello(String name) {
		return fibonacciService.sayHello(name);
	}
}