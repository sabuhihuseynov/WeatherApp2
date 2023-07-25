package org.example.dao.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Country country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE)
    private List<Weather> weatherList;

}
