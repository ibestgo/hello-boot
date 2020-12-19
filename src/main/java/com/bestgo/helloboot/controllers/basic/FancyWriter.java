package com.bestgo.helloboot.controllers.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("fancy")
@Component("fancy")     // the above works too. I prefer this style
@Primary
public class FancyWriter implements TextWriter {
  @Override
  public String write() {
    return "Fancy Writer2";
  }
}
