package org.example.model.dto;

public record LocationResponseDTO(String cityName,
                                  String countryName,
                                  double latitude,
                                  double longitude) {
}
