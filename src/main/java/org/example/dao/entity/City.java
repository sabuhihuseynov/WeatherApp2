package org.example.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

}
