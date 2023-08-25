package org.example.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "days")
public class Day extends BaseEntity {

    private double maxtemp_c;
    private double maxtemp_f;
    private double mintemp_c;
    private double mintemp_f;
    private double avgtemp_c;
    private double avgtemp_f;
    @Column(name = "maxwind_kph")
    private double maxWind;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weather_condition_code")
    private WeatherCondition weatherCondition;

}
