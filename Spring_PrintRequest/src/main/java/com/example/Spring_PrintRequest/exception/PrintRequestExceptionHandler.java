package com.example.Spring_PrintRequest.exception;

import com.example.Spring_PrintRequest.controller.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class PrintRequestExceptionHandler {


    @ExceptionHandler({PrintRequestNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleCardNotFound(PrintRequestNotFoundException exception, HttpServletRequest
            httpServletRequest) {
        return new ResponseEntity(ErrorResponse.ErrorResponseBuilder.anErrorResponse().withMessage(exception.getMessage())
                .withStatusCode(HttpStatus.NOT_FOUND.value())
                .withTime(ZonedDateTime.now()).build(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> generalHandler(Exception exception, HttpServletRequest
            httpServletRequest) {
        return new ResponseEntity(ErrorResponse.ErrorResponseBuilder.anErrorResponse().withMessage(exception.getMessage())
                .withStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withTime(ZonedDateTime.now()).build(), HttpStatus.BAD_REQUEST);
    }

}
