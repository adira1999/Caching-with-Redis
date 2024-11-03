package com.example.advanced_caching.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;

@Service
public class CacheService {

    @Autowired
    private WeatherService weatherService;

    // Cache-aside: Load data on cache miss
    @Cacheable(value = "weatherCache2", key = "#city")
    public String getWeather(String city) {
        // Simulate fetching data from a primary data source, e.g., a database
        return weatherService.getDefaultWeather(city);
    }

    // Write-through: Update both cache and data source on data update
    @CachePut(value = "weatherCache2", key = "#city")
    public String updateWeather(String city, String newWeather) {
        return newWeather;
    }

}
