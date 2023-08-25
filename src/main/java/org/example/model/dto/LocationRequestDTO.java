package org.example.model.dto;

public record LocationRequestDTO(String name,
                                 String region,
                                 String country,
                                 double lat,
                                 double lon,
                                 String tz_id,
                                 long localtime_epoch,
                                 String localtime) {
}
