package com.example.demo.Exception;




import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobelExceptionHandler {

	
	
	@ExceptionHandler(IlligalIInputEception.class)
	public ResponseEntity<MyErrorDetails> custmExcption(IlligalIInputEception ie, WebRequest wr)
	{
		
		MyErrorDetails mr=new MyErrorDetails(LocalTime.now(), ie.getMessage(), wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(mr,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noException(NoHandlerFoundException noh,WebRequest req){
		
		MyErrorDetails mr=new MyErrorDetails(LocalTime.now(),noh.getMessage(),req.getDescription(false));

	return new ResponseEntity<MyErrorDetails>(mr, HttpStatus.BAD_REQUEST);	
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> mymnvfError(MethodArgumentNotValidException m){
		
		MyErrorDetails mr=new MyErrorDetails(LocalTime.now(), m.getMessage(), m.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyErrorDetails>(mr, HttpStatus.BAD_REQUEST);
	}
	
}
