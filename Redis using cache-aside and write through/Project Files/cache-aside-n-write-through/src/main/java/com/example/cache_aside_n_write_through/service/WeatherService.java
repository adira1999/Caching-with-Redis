package com.example.cache_aside_n_write_through.service;


import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    // Mock database
    private static final Map<String, String> database = new HashMap<>();

    static {
        database.put("NewYork", "Sunny");
        database.put("India", "Rainy");
    }

    // Cache-aside pattern: Check Redis cache; if missing, get from "database" and store in cache.
    @Cacheable(value = "weatherCache", key = "#location")
    public String getWeather(String location) {
        System.out.println("Fetching from database for location: " + location);
        return database.getOrDefault(location, "Data not found");
    }

    // Write-through pattern: Update both the cache and "database" on changes.
    @CachePut(value = "weatherCache", key = "#location")
    public String updateWeather(String location, String weather) {
        System.out.println("Updating database and cache for location: " + location);
        database.put(location, weather);
        return weather;
    }
}
