package com.lt.workshop.beekeeper.endpointer;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.lt.workshop.beekeeper.service.BeekeeperService;
import com.lt.workshop.beekeeper.vo.User;

@RestSchema(schemaId = "userRestEndpoint")
@RequestMapping("/userRest")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private final BeekeeperService beekeeperService;

	private static RestTemplate restTemplate = RestTemplateBuilder.create();
	
	@Autowired
	UserController(BeekeeperService beekeeperService) {
		this.beekeeperService = beekeeperService;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String addUser(String userid,String userName,String password) {
		
		logger.info(userid+userName+password);
		return beekeeperService.addUser(userid, userName, password);
	}
	
    
    
    @RequestMapping(value = "/listUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String listUser(String userid,String userName,String password) {
		
		logger.info(userid+userName+password);
		String result = restTemplate
	            .getForObject("cse://worker/user/addUser?userid="+userid+"&userName="+userName+"&password="+password, String.class);
		return result;
	}
}
