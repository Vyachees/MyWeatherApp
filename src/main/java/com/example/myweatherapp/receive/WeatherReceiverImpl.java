package com.example.myweatherapp.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherReceiverImpl implements WeatherReceiver {

    private final RestTemplate restTemplate;

    public WeatherReceiverImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Quote getWeather(String city) {
       // return args -> {
        log.info("Start receive weather");
            Quote quote= restTemplate.getForObject(
                    "http://api.weatherstack.com/current?access_key=" +
                            "YOUR API KEY FOR THIS RESOURCE" +
                            "&query="+city
                    //"http://localhost:8090/greeting"
                    //"https://api.chucknorris.io/jokes/random"
                    , Quote.class);
        assert quote != null;
        log.info(quote.toString());
            return quote;
      //  }
    }
}
