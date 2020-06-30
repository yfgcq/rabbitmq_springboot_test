package com.tsl.rabbitmq_springboot_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RabbitmqSpringbootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqSpringbootTestApplication.class, args);
	}

}
