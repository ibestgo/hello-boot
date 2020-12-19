package com.bestgo.helloboot.controllers.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("regular")
public class RegularWriter implements TextWriter {
  @Override
  public String write() {
    return "Regular Writer2";
  }
}
