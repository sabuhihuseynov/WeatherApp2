package org.example.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Locale;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundExceptions(EntityNotFoundException ex, Locale locale) {
        log.error("Not Found Error Occurred! : {} not found!", ex.getMessage());
        ExceptionResponse response = new ExceptionResponse();
        Object[] params = {ex.getMessage()};
        String errorMessage = messageSource.getMessage("NOT_FOUND", params, locale);
        response.setLocalDateTime(LocalDateTime.now());
        response.setMessage(errorMessage);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
