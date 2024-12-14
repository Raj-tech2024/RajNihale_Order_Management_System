package com.example.ECommerce_Eurekha_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ECommerceEurekhaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceEurekhaServerApplication.class, args);
	}

}
