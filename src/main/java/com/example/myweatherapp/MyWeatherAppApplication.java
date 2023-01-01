package com.example.myweatherapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
public class MyWeatherAppApplication {

	private static final Logger log = LoggerFactory.getLogger(MyWeatherAppApplication.class);

	public MyWeatherAppApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyWeatherAppApplication.class, args);
	}

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	@PostConstruct
	@Transactional
	public void onPostConstruct() {
		log.debug("Update DB Scheme");
		jdbcTemplate.update("CREATE TABLE IF NOT EXISTS weathers (weather text);");
		log.debug("Updated successfully");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
