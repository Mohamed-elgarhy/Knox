package com.konux.interview.assignment.support;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.konux.interview.assignment.dto.ErrorDetails;
import com.konux.interview.assignment.dto.LogEntry;
import com.konux.interview.assignment.exceptions.InvalidArgumentException;
import com.konux.interview.assignment.interfaces.LogService;


@RestController
public class LogController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LogService logService;

	@GetMapping(path = "/get", name = "testGetEndPoint")
	public String testGet() {
		return "Greetings from the Konux interview test assignment!";
	}
	
	@PostMapping(path="/log")
	String logEntryDetails(@RequestBody LogEntry logEntry ) {
		
		logService.logServiceDetails(logEntry);
		
		return "success";
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorDetails> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
	    String name = ex.getName();
	    String type = ex.getRequiredType().getSimpleName();
	    Object value = ex.getValue();
	    String message = String.format("'%s' should be a valid '%s' and '%s' isn't", 
	                                   name, type, value);

	    ErrorDetails errorDetails = new ErrorDetails(new Date(), message ,
	            "Error code : " + ex.getErrorCode());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidArgumentException.class)
	public ResponseEntity<ErrorDetails> handleInvalidArguments(InvalidArgumentException ex) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage() ,
	            "Error code : " + ex.getErrorCode());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
