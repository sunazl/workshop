package com.lt.workshop.beekeeper.endpointer;


import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lt.workshop.beekeeper.service.BeekeeperService;
import com.lt.workshop.beekeeper.vo.Ancestor;


@RestSchema(schemaId = "beekeeperRestEndpoint")
@RequestMapping("/rest")
@Controller
public class BeekeeperController {

  private static final Logger logger = LoggerFactory.getLogger(BeekeeperController.class);

  private final BeekeeperService beekeeperService;

  @Autowired
  BeekeeperController(BeekeeperService beekeeperService) {
    this.beekeeperService = beekeeperService;
  }

  @RequestMapping(value = "/drone/ancestors/{generation}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Ancestor ancestorsOfDrone(@PathVariable int generation) {
    logger.info(
        "Received request to find the number of ancestors of drone at generation {}",
        generation);

    return new Ancestor(beekeeperService.ancestorsOfDroneAt(generation));
  }

  @RequestMapping(value = "/queen/ancestors/{generation}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public Ancestor ancestorsOfQueen(@PathVariable int generation) {
    logger.info(
        "Received request to find the number of ancestors of queen at generation {}",
        generation);

    return new Ancestor(beekeeperService.ancestorsOfQueenAt(generation));
  }
  @RequestMapping(value = "/sayHello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  public String sayHello(@PathVariable String name) {
    logger.info("Received request to find the name {}",name);

    return beekeeperService.sayHello(name);
  }
}
