package com.lt.workshop.doorman.endpoint;


import static org.springframework.http.HttpStatus.REQUEST_TIMEOUT;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import com.lt.workshop.doorman.service.AuthenticationService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestSchema(schemaId = "authenticationRestEndpoint")
@RequestMapping("/rest")
@Controller
public class AuthenticationController {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

  static final String USERNAME = "username";
  static final String PASSWORD = "password";
  static final String TOKEN = "token";

  private final AuthenticationService authenticationService;
  private final AuthorizationHeaderGenerator authorizationHeaderGenerator;
  @Autowired
  public AuthenticationController(AuthenticationService authenticationService
		  ,AuthorizationHeaderGenerator authorizationHeaderGenerator) {
    this.authenticationService = authenticationService;
    this.authorizationHeaderGenerator = authorizationHeaderGenerator;
  }
  @RequestMapping(value = "/set/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String ancestorsOfDrone(@PathVariable String name) {
    logger.info(
        "Received request to find the number of ancestors of drone at generation {}",
        name);

    return "hello，" + name;
  }
  @HystrixCommand(fallbackMethod = "timeout")
  @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> login() {
	long num = 0;
	long now = System.currentTimeMillis();
	while(true) {
		for(int i = 0; i< 100000;i++) {
			num++;
		}
		if(System.currentTimeMillis()-now>=1000) {
			break;
		}
	}
	logger.info("花费时间{}秒",System.currentTimeMillis()-now);
	String username = "jordan";
	String password = "password";
    logger.info("Received login request from user {}", username);
    String token = authenticationService.authenticate(username, password);
    HttpHeaders headers = authorizationHeaderGenerator.generate(token);
    
    logger.info("Authenticated user {}{}{}{}successfully", username,headers,token);
    return new ResponseEntity<>("Welcome, " + username, headers, HttpStatus.OK);
  }

  private ResponseEntity<String> timeout() {
	    logger.warn("Request to validate token {} timed out");
	    return new ResponseEntity<>(REQUEST_TIMEOUT);
	  }
  
  @RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String validate(@RequestBody Token token) {
    logger.info("Received validation request of token {}", token);
    return authenticationService.validate(token.getToken());
  }
}

