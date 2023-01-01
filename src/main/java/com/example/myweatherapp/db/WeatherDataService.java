package com.example.myweatherapp.db;

import java.util.List;

public interface WeatherDataService {
    void save(String weather);

    List<String> getAll();
}
