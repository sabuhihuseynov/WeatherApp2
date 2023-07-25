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
@Table(name = "countries")
public class Country extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
    private List<City> cities;

}
