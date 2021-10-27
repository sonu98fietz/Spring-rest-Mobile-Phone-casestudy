package com.example.springbootrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springbootrestdemo.mapper.MobilePhoneMapper;
import com.example.springbootrestdemo.mapper.MobilePhoneMapperImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MobileStoreAPI", version = "1.0", description = "API for Mobile Store Service"))
public class Springbootrestdemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootrestdemo2Application.class, args);
	}

	@Bean
	public MobilePhoneMapper getMapper() {
		return new MobilePhoneMapperImpl();
	}
}
