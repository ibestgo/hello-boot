package com.bestgo.helloboot.play;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

// https://www.baeldung.com/spring-boot-health-indicators
// All we have to do is to register an implementation of the HealthIndicator interface as a Spring bean.
// endpoint will be: /actuator/health/random
// The bean name will be randomHealthIdenticator. The "random" before HealthIdenticator will be used as a path element
// OR you can have @Component("random")
@Component
public class RandomHealthIndicator implements HealthIndicator {

  @Override
  public Health health() {
    // math#Random is a global random generator
    double chance = ThreadLocalRandom.current().nextDouble();
    Health.Builder status = Health.up().withDetail("SERVICE A", "Available");
    if(chance > 0.7) {
      status = Health.down().withDetail("SERVICE A", "Not Available");
    }
    return status.build();
  }

//  @Override
//  public Health getHealth(boolean includeDetails) {
//    return Health.up().build();
//  }
}
