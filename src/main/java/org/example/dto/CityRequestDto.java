package org.example.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CityRequestDto {

    @NotBlank
    private String name;
    private Integer countryId;

}
