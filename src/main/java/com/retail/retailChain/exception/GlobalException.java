package com.retail.retailChain.exception;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import io.jsonwebtoken.*;

@ControllerAdvice
public class GlobalException{

	@ExceptionHandler(value 
		      = { DateTimeParseException.class })
		    protected ResponseEntity<String> handleDateTimeParseException(
		    		DateTimeParseException request) {
		        String bodyOfResponse = "Date Format should be yyyy-MM-dd.Please recheck";
		        return new ResponseEntity<String>(bodyOfResponse,HttpStatus.BAD_REQUEST);
		    }	
	@ExceptionHandler(value 
		      = { NoRecordFoundException.class })
		    protected ResponseEntity<String> handleNoRecordFoundException(
		    		NoRecordFoundException request) {
		        String bodyOfResponse = "No Record Found";
		        return new ResponseEntity<String>(bodyOfResponse,HttpStatus.NOT_FOUND);
		    }
	@ExceptionHandler(value 
		      = { ObjectNotFoundException.class })
		    protected ResponseEntity<String> handleObjectNotFoundException(
		    		ObjectNotFoundException request) {
		        String bodyOfResponse = "No Record Found";
		        return new ResponseEntity<String>(bodyOfResponse,HttpStatus.NOT_FOUND);
		    }
	@ExceptionHandler(value 
		      = { HttpRequestMethodNotSupportedException.class })
		    protected ResponseEntity<String> handleHttpRequestMethodNotSupportedException(
		    		HttpRequestMethodNotSupportedException request) {
		        String bodyOfResponse = "Wrong Method type";
		        return new ResponseEntity<String>(bodyOfResponse,HttpStatus.METHOD_NOT_ALLOWED);
		    }
	@ExceptionHandler(value 
		      = { SignatureException.class })
		    protected ResponseEntity<String> handleJWTSignatureException(
		    		SignatureException request) {
		        String bodyOfResponse = "JWT signature mismatch";
		        return new ResponseEntity<String>(bodyOfResponse,HttpStatus.FORBIDDEN);
		    }
	@ExceptionHandler(value 
		      = { ResourceNotFoundException.class })
		    protected ResponseEntity<String> handleResourceNotFoundException(
		    		ResourceNotFoundException request) {
		        String bodyOfResponse = "User not found ";
		        return new ResponseEntity<String>(bodyOfResponse,HttpStatus.FORBIDDEN);
		    }
}
