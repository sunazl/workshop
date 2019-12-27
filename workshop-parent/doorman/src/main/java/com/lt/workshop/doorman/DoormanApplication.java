package com.lt.workshop.doorman;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableCircuitBreaker
@EntityScan("com.lt.workshop.doorman.auth.domain")
@EnableJpaRepositories("com.lt.workshop.doorman.auth.domain")
@EnableAutoConfiguration(exclude={JpaRepositoriesAutoConfiguration.class})
@SpringBootApplication
@EnableServiceComb
public class DoormanApplication {

  public static void main(String[] args) {
    SpringApplication.run(DoormanApplication.class, args);
  }
}
