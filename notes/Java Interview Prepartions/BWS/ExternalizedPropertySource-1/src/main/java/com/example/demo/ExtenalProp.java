package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
@PropertySource(value = {"file:\\Users\\Deepa\\learning\\DOC\\DOC\\notes\\spring\\common.application.properties"})
public class ExtenalProp {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
