package com.noturaun.flickertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

@SpringBootApplication
public class FlickertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlickertestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder
				.setConnectTimeout(Duration.ofMillis(10000))
				.setReadTimeout(Duration.ofMillis(5000))
				.build();
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/feeds").allowedOrigins("http://localhost:8080");
			}
		};
	}
}
