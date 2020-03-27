package com.example.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Autowired
	private DemoApplication demoApplication;

	@Value("${demo-application.message}")

	private String messageProperty;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Hello world from hello_world_application");
		System.out.println(messageProperty);
	}
}
