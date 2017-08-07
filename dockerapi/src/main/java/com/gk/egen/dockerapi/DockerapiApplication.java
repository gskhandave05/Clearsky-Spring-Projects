package com.gk.egen.dockerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.gk.egen.dockerapi.config.SwaggerConfig;
import com.gk.egen.dockerapi.config.WebConfig;

@SpringBootApplication
@EnableAutoConfiguration
@Import({WebConfig.class,SwaggerConfig.class})
@ComponentScan("com.gk.egen.dockerapi.controller")
@ComponentScan("com.gk.egen.dockerapi.entity")
@ComponentScan("com.gk.egen.dockerapi.repository")
@ComponentScan("com.gk.egen.dockerapi.service")
@ComponentScan("com.gk.egen.dockerapi.config")
public class DockerapiApplication {

	public static void main(String[] args) {
//		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,"prod");
		SpringApplication.run(DockerapiApplication.class, args);
	}
	
}
