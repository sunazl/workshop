package com.lt.workshop.beekeeper.config;

import org.apache.servicecomb.provider.pojo.RpcReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lt.workshop.beekeeper.service.BeekeeperService;
import com.lt.workshop.beekeeper.service.FibonacciCalculator;
import com.lt.workshop.beekeeper.service.UserService;
import com.lt.workshop.beekeeper.service.impl.BeekeeperServiceImpl;

@Configuration
public class BeekeeperConfig {

  @RpcReference(microserviceName = "worker", schemaId = "fibonacciRpcEndpoint")
  private FibonacciCalculator fibonacciCalculator;

  @RpcReference(microserviceName = "worker", schemaId = "userservice")
  private UserService userService;
  @Bean
  public BeekeeperService beekeeperService() {
    return new BeekeeperServiceImpl(fibonacciCalculator,userService);
  }
}