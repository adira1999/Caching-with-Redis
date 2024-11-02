package com.example.cache_aside_n_write_through;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheAsideNWriteThroughApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheAsideNWriteThroughApplication.class, args);
	}

}
