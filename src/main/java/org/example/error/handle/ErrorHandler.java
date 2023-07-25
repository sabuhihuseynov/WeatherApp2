package org.example.error.handle;


import lombok.extern.slf4j.Slf4j;
import org.example.error.ErrorResponse;
import org.example.error.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public ErrorResponse handleUnexpectedError(RuntimeException ex) {
        log.error("Action.handleValidationException.error validate exception: {}", ex.toString());
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        log.error("Action.handleNotFoundException.error not found exception: {}", ex.toString());
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }

}
