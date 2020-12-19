package com.bestgo.helloboot.controllers.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CarTestService {

  //@Qualifier("bus")
  @Autowired
  CarService carService;

  public String testCar() {
    return carService.start();
  }
}
