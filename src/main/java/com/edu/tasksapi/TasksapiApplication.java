package com.edu.tasksapi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class TasksapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksapiApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(Environment environment) {
		return args -> {
			log.info("message from application.properties "
					+ environment.getProperty("message-from-application-properties"));
		};
	}
}
