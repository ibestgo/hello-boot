package com.bestgo.helloboot.controllers.basic;

public class BusService implements CarService {
  @Override
  public String start() {
    return "Bus Service";
  }
}
