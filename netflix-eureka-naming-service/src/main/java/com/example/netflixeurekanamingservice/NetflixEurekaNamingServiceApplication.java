package com.example.netflixeurekanamingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class NetflixEurekaNamingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixEurekaNamingServiceApplication.class, args);
	}

}
