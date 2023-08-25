package org.example.dao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "forecast_day")
public class ForecastDay extends BaseEntity {

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "day_id")
    private Day day;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "astro_id")
    private Astro astro;
    @OneToMany(mappedBy = "forecastDay")
    private List<HourlyWeather> hourlyWeatherList;

}
