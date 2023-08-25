package org.example.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "astro")
public class Astro extends BaseEntity {

    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;

}
