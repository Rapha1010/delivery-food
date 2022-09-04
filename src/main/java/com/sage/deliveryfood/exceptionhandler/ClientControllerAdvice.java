package com.sage.deliveryfood.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ClientControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> clientNotFound(ClientNotFoundException clientNotFound) {
		MessageExceptionHandler error = new MessageExceptionHandler(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "client not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ResponseBody
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> orderNotFound(OrderNotFoundException orderNotFound) {
		MessageExceptionHandler error = new MessageExceptionHandler(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "order not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ResponseBody
	@ExceptionHandler(OrderItenNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> orderItenNotFound(OrderItenNotFoundException orderItenNotFound) {
		MessageExceptionHandler error = new MessageExceptionHandler(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "order iten not found");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageExceptionHandler> argumentsNotValid(MethodArgumentNotValidException notValid) {
		
		BindingResult result = notValid.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		
		StringBuilder sb = new StringBuilder();
		
		for (FieldError fieldError : fieldErrors) {
		
			sb.append("field -> " + fieldError.getField());
			sb.append(" = " + fieldError.getDefaultMessage());
			
		}
		
		MessageExceptionHandler error = new MessageExceptionHandler(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), sb.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
