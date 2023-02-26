package org.example.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class CountryRequestDto {

    @NotBlank(message = "The country name is required.")
    private String name;

}
