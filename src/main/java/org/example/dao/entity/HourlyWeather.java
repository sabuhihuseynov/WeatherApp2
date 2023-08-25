package org.example.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hourly_weathers")
public class HourlyWeather extends BaseEntity {

    private String time;
    private double temp_c;
    private double temp_f;
    @Column(name = "wind_kph")
    private double windSpeed;
    @OneToOne
    @JoinColumn(name = "weather_condition_code")
    private WeatherCondition weatherCondition;
    @ManyToOne(fetch = FetchType.LAZY)
    private ForecastDay forecastDay;

}
