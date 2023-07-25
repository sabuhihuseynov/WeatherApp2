package org.example.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@Entity
@Table(name = "weathers")
public class Weather extends BaseEntity {
    private String type;
    private double temperature;
    private double windSpeed;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private City city;

}
