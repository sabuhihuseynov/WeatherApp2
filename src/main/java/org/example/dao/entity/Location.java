package org.example.dao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    private String cityName;
    private String countryName;
    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE)
    private List<ForecastDay> forecastDay;

}
