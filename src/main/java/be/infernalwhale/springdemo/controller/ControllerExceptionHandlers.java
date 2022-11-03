package be.infernalwhale.springdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;

@RestControllerAdvice
public class ControllerExceptionHandlers {
    @ExceptionHandler
    public ResponseEntity handleNPException(NullPointerException ex) {
        return ResponseEntity
                .internalServerError()
                .body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity handleValidationExceptions(ValidationException exception) {
        return ResponseEntity
                .badRequest()
                .body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity handleGeneralExceptions(Exception exception) {
        return ResponseEntity.internalServerError().body("General exception flow");
    }
}
