package com.example.springbootpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.springbootpoc.model.FileStorageProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({FileStorageProperties.class})
public class SpringBootPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPocApplication.class, args);
		System.out.println("Hello World");
	}

}
