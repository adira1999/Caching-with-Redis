package com.example.advanced_caching.service;


import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public String getDefaultWeather(String city) {
        // Simulate fetching data from a primary data source, e.g., a database
        return "Default Weather for " + city;
    }
}
