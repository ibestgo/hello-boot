package com.bestgo.helloboot.controllers.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfiguration {
  @ConditionalOnProperty(value="car.service.mode", havingValue = "truck", matchIfMissing = false)
  //@Primary
  @Bean         // bean name: truckServiceConfiguration
  public CarService truckServiceConfiguration() {
    return new TruckService();
  }

  @ConditionalOnProperty(value="car.service.mode", havingValue = "bus", matchIfMissing = true)
  //@Qualifier("bus")
  //@Bean("bus")      // bean name is bus. This pattern is better.
  @Bean
  public CarService busServiceConfiguration() {
    return new BusService();
  }
}
