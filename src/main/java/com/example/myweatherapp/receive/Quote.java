package com.example.myweatherapp.receive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private LocationBase location;
    private CurrentBase current;

    public Quote() {
    }


    @Override
    public String toString() {
        return ""+location+current;
                //(location + current+"");
                /*"Quote{" +
                "location='" + location + '\'' +
                ", current=" + current +
                '}';*/
    }
}
