package com.example.myweatherapp.receive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationBase {
    private String name;
    private String localtime;

    public LocationBase() {
    }



    @Override
    public String toString() {
        return
               ""+   localtime+", "+name+" "
                /* "Location{" +
                "name=" + name +
                ", localtime='" + localtime + '\'' +
                '}'*/
                ;
    }
}
