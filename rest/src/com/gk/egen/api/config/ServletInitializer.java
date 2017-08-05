package com.gk.egen.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author gauravkhandave
 *	Date : 08/01/2017
 *	Version : 1.0.0
 *	
 *	This is entry point of the web application.
 */

@Configuration
@ComponentScan("com.gk.egen.api.controller")
@ComponentScan("com.gk.egen.api.entity")
@ComponentScan("com.gk.egen.api.repository")
@ComponentScan("com.gk.egen.api.service")
@ComponentScan("com.gk.egen.api.config")
public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return  new Class[] { WebConfig.class, JPAConfig.class, SwaggerConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return  new String[] { "/*" };
	}

}
