package com.rest.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest.exception.IdNotFoundException;

@RestControllerAdvice
public class MyRestControllerException {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Error> errResponse(IdNotFoundException infe){
		Error e = new Error();
		e.setErrCode("420");
		e.setErrStatus("Given Id is does not exists in database");
		return new ResponseEntity<Error>(e, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> exception(Exception e){
		Error err = new Error();
		err.setErrCode("220");
		err.setErrStatus("ReST API is invalid..");
		return new ResponseEntity<Error>(err,HttpStatus.NOT_FOUND);
	}

}
