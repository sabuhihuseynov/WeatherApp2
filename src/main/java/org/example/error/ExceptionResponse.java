package org.example.error;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private String message;
    private LocalDateTime localDateTime;

}
