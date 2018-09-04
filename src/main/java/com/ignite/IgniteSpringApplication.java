package com.ignite;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@ComponentScan("com.ignite")
@SpringBootApplication
@EntityScan(basePackages= {"com.ignite.model"})
@EnableIgniteRepositories("com.ignite.repository")
@Import({IgniteConfig.class})
@Configuration
public class IgniteSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgniteSpringApplication.class, args);
	}

}
