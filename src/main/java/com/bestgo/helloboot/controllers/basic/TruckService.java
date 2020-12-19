package com.bestgo.helloboot.controllers.basic;

public class TruckService implements CarService {
  @Override
  public String start() {
    return "Truck Service";
  }
}
