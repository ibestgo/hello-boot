package com.bestgo.helloboot;

import com.bestgo.helloboot.controllers.basic.CarService;
import com.bestgo.helloboot.controllers.basic.CarTestService;
import com.bestgo.helloboot.controllers.basic.TextWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HellobootApplication {

	private static final Logger logger = LoggerFactory.getLogger(HellobootApplication.class);

	public static void main(String[] args) {
		logger.info("+++++++++++++++++++++ Logger Info ++++++++++++++++++++++++");
		ConfigurableApplicationContext context = SpringApplication.run(HellobootApplication.class, args);

//		TextWriter writer = context.getBean(TextWriter.class);
//		System.out.println("WRITE: "+writer.write());

		CarTestService carService = context.getBean(CarTestService.class);
		System.out.println("WRITE: "+carService.testCar());
	}

}
