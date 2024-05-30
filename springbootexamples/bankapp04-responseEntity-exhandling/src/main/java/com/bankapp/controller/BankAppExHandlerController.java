package com.bankapp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//@RestControllerAdvice indicate it is a special controller that handle ex using AOP*

import com.bankapp.dto.ErrorInfo;
import com.bankapp.exception.BankAccountNotFoundException;
@RestControllerAdvice
public class BankAppExHandlerController {

	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(BankAccountNotFoundException ex){
		
		ErrorInfo errorInfo= ErrorInfo.builder()
				.error(ex.getMessage())
				.toContact("ravi@ora.com")
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.NOT_FOUND.toString())
				.build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handle500(Exception ex){
		
		ErrorInfo errorInfo= ErrorInfo.builder()
				.error("pls try after some time")
				.toContact("ravi@ora.com")
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
				.build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}
}
