package com.lme.martianrobots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lme.martianrobots")
public class MartianRobotsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MartianRobotsApplication.class, args);
	}
}
