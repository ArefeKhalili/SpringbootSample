package com.example.Spring_PrintRequest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PrintRequestNotFoundException extends RuntimeException{

    public PrintRequestNotFoundException(String message) {
        super(message);
    }

    public PrintRequestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrintRequestNotFoundException(Throwable cause) {
        super(cause);
    }
}
