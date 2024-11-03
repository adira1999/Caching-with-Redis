package com.example.advanced_caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AdvancedCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedCachingApplication.class, args);
	}

}
