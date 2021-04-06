package br.com.mpsuporteti.cafenaestrada.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mpsuporteti.cafenaestrada.services.exceptions.DataIntegrityException;
import br.com.mpsuporteti.cafenaestrada.services.exceptions.ObjectNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> IntegridadeDados(DataIntegrityException e, HttpServletRequest request) {
		StandardError erro = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> Validador(MethodArgumentNotValidException e, HttpServletRequest request) {
		ErroValidacao erro = new ErroValidacao(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.addError(x.getField(), x.getDefaultMessage());
	}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

}
