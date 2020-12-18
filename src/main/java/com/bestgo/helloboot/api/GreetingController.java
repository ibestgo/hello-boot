package com.bestgo.helloboot.api;

import com.bestgo.helloboot.play.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

  // Example of getting single configuration
  @Value("${my.greeting: default value}")
  private String greetMessage;

  @Value("some static value")
  private String staticMessage;

  @Value("${my.list.values}")
  private List<String> listValues;

  // Example of getting a group of configurations
  @Autowired
  private DbSettings dbSettings;

  @GetMapping("/greeting")
  public String greeting() {
    // <br> worked!
    return "Hello connection: "+dbSettings.getConnection()+"<br>"+greetMessage+"\n"+staticMessage+"\n"+listValues;
  }
}
