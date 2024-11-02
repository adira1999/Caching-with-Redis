package com.example.redis.service;


import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


@Service
public class WeatherService {

    @Cacheable(value = "weatherCache", key = "#city", unless = "#result == null")
    public String getWeather(String city) {
        // Simulate a slow API call
        simulateSlowService();
        return "Weather in " + city + ": Sunny";  // Replace with actual data fetching logic
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(3000);  // Simulates a 3-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
