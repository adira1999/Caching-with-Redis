package com.example.advanced_caching.controller;


import com.example.advanced_caching.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cache/weather")
public class WeatherController {

    @Autowired
    private CacheService cacheService;


    // GET endpoint to retrieve weather (Cache-Aside strategy)
    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        return cacheService.getWeather(city);
    }

    // POST endpoint to update weather (Write-Through strategy)
    @PostMapping("/{city}")
    public String updateWeather(@PathVariable String city, @RequestParam String weather) {
        return cacheService.updateWeather(city, weather);
    }

}
