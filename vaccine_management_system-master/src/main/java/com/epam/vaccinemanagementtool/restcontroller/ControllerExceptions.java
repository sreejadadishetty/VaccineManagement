package com.epam.vaccinemanagementtool.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@RestControllerAdvice
public class ControllerExceptions {
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<ControllerExceptionHandler> handleCourseNotFoundException(MissingServletRequestParameterException exception, WebRequest request) {
        ControllerExceptionHandler exRes = new ControllerExceptionHandler();
        exRes.setError(exception.getMessage());
        exRes.setStatus(HttpStatus.BAD_REQUEST.name());
        exRes.setTimestamp(LocalDate.now().toString());
        exRes.setPath(request.getDescription(false));
        return new ResponseEntity<ControllerExceptionHandler>(exRes, HttpStatus.BAD_REQUEST);
    }
}
