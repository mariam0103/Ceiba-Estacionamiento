package co.com.ceiba.CeibaEstacionamiento.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.apache.log4j.Logger;

import co.com.ceiba.CeibaEstacionamiento.exception.CeibaException;
import co.com.ceiba.CeibaEstacionamiento.exception.PersistenceException;
import co.com.ceiba.CeibaEstacionamiento.model.ResponseError;

	@ControllerAdvice
	public class ExceptionHandlerr {
	private static final Logger LOGGER = Logger.getLogger(ExceptionHandlerr.class);

	@ExceptionHandler(CeibaException.class)
	public ResponseEntity<ResponseError> domainExceptionHandler(CeibaException ex) {
	ResponseError response = new ResponseError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	LOGGER.error("Domain Error Description:", ex);
	return new ResponseEntity<ResponseError>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PersistenceException.class)
	public ResponseEntity<ResponseError> persistenceExceptionHandler(PersistenceException ex) {
	ResponseError response = new ResponseError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	LOGGER.error("Persistence Error Description:", ex);
	return new  ResponseEntity<ResponseError>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ResponseError> generalException(Throwable ex) {
	ResponseError response = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	"Ha ocurrido un error en el servidor, por favor verificar con el administrador");
	LOGGER.error("General System Error Description:", ex);
	return new ResponseEntity<ResponseError>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
