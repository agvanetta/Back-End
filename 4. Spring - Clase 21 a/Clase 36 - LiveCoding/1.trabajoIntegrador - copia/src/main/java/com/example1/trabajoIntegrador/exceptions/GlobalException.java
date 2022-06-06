package com.example1.trabajoIntegrador.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Quito
public class GlobalException {

    @ExceptionHandler({ResourceNotFoundException.class}) // Quito
    public ResponseEntity<String> procesarErrorNotFound(ResourceNotFoundException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage() + " | GlobalEx");
    }

}
