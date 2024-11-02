package com.example.cache_aside_n_write_through.controller;


import com.example.cache_aside_n_write_through.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Cache-aside: Retrieve data, check cache, and update if not present
    @GetMapping("/{location}")
    public String getWeather(@PathVariable String location) {
        return weatherService.getWeather(location);
    }

    // Write-through: Update both cache and database
    @PostMapping("/{location}")
    public String updateWeather(@PathVariable String location, @RequestParam String weather) {
        return weatherService.updateWeather(location, weather);
    }

}
