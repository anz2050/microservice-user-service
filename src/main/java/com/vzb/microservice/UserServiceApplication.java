package com.vzb.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan (basePackages={"com.vzb.microservice"})
public class UserServiceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceApplication.class);

	public static void main(String[] args) {
		logger.trace("Starting main method...");
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
}
