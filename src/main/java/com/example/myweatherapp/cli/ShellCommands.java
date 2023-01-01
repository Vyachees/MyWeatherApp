package com.example.myweatherapp.cli;


import com.example.myweatherapp.db.WeatherDataService;
import com.example.myweatherapp.receive.WeatherReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@ShellComponent
public class ShellCommands {
    private final WeatherReceiver weatherReceiver;
    private final WeatherDataService weatherDataService;
    public ShellCommands(WeatherReceiver weatherReceiver, WeatherDataService weatherDataService) {
        this.weatherReceiver = weatherReceiver;

        this.weatherDataService = weatherDataService;
    }

    private String lastWeather;



    @ShellMethod("Check weather of city")
    public String weather(String city){
      //  this.city=city;
        lastWeather=weatherReceiver.getWeather(city).toString();
        return lastWeather;
    }

    @ShellMethod("Get last weather")
    public String last() {
        return Optional.ofNullable(lastWeather).orElse("No weathers yet");
    }

    @ShellMethod("Save it!")
    public String save() {
        if (Objects.nonNull(lastWeather)) {
            weatherDataService.save(lastWeather);
        }

        return "saved";
    }

    @ShellMethod("Show all saved")
    public String show() {
        return String.join("\n", weatherDataService.getAll());
    }

}
