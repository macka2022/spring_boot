package com.projetreactjs.demo.Exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;


@AllArgsConstructor
public class ApiException {
    private final String message;
     private final Throwable throwable;
     private final ZonedDateTime timestamp;
     private final HttpStatus httpstatus;


}
