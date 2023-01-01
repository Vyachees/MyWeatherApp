package com.example.myweatherapp.receive;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentBase {
    private String temperature;


    public CurrentBase() {
    }



    @Override
    public String toString() {
        return
                ",temperature = "+ temperature
               /* "Current{" +
                "temperature=" + temperature +
                //", localtime='" + localtime + '\'' +
                "\"}"*/
                ;
    }
}
