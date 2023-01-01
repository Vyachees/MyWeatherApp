package com.example.myweatherapp.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JdbcWeatherDataServiceImpl implements WeatherDataService{

    private final JdbcTemplate jdbcTemplate;

    public JdbcWeatherDataServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(String weatherText) {
        jdbcTemplate.update("insert into weathers (weather) values (?)", weatherText);
    }

    @Override
    public List<String> getAll() {
        return jdbcTemplate.query("select weather from weathers",
                (rs, rowNum) -> rs.getString("weather"));
    }
}
