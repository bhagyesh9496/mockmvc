package com.demotest.mockdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class MockDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockDemoApplication.class, args);
	}

}
