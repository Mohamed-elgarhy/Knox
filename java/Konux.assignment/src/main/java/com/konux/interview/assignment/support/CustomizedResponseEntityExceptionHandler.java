package com.konux.interview.assignment.support;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.konux.interview.assignment.dto.ErrorDetails;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({Exception.class,RuntimeException.class})
  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) {
	  String message = ex.getMessage();
	if (ex.getMessage() == null)
	{
		message = ex.getCause().toString();
	}
	  
    ErrorDetails errorDetails = new ErrorDetails(new Date(), message ,
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
}
