package com.gk.egen.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.gk.egen.api.config.SwaggerConfig;
import com.gk.egen.api.config.WebConfig;

@SpringBootApplication
@EnableAutoConfiguration
@Import({WebConfig.class,SwaggerConfig.class})
@ComponentScan("com.gk.egen.api.controller")
@ComponentScan("com.gk.egen.api.entity")
@ComponentScan("com.gk.egen.api.repository")
@ComponentScan("com.gk.egen.api.service")
@ComponentScan("com.gk.egen.api.config")
public class Application {

	public static void main(String[] args) {
//		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,"prod");
		SpringApplication.run(Application.class, args);
	}
	
}
