package com.yunguo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//test
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//test
@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class yunGuoApplication {

	public static void main(String[] args) 	{
		SpringApplication.run(yunGuoApplication.class, args);
	}
}