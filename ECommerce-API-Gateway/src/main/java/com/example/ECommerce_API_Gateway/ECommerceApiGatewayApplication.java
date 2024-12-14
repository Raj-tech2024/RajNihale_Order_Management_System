package com.example.ECommerce_API_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ECommerceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApiGatewayApplication.class, args);
	}

}
