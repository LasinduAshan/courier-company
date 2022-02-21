package com.misyn.courier.company.advisor;

import com.misyn.courier.company.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<StandardResponse> handleException(RuntimeException ex){
        StandardResponse response = new StandardResponse(500, "error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
