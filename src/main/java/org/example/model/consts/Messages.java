package org.example.model.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Messages {
    public static final String COUNTRY_NOT_FOUND = "country.not.found";
    public static final String COUNTRY_NOT_FOUND_MSG = "Provided country not found";
    public static final String CITY_NOT_FOUND = "city.not.found";
    public static final String CITY_NOT_FOUND_MSG = "Provided city not found";
    public static final String WEATHER_NOT_FOUND = "weather.not.found";
    public static final String WEATHER_NOT_FOUND_MSG = "Provided weather not found";
}
