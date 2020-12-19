package com.bestgo.helloboot.controllers.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

  @Autowired
  @Qualifier("regular")
  private TextWriter writer;

  @GetMapping("/basic")
  public String getBasic() {
    return writer.write();
  }
}
