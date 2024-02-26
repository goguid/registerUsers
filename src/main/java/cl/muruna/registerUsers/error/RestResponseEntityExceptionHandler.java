package cl.muruna.registerUsers.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import cl.muruna.registerUsers.util.MessageResponse;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            Map<String, Object> errors = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(error ->{
                errors.put(error.getField(), error.getDefaultMessage());
            });

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<MessageResponse> runtimeExceptionHandler(RuntimeException ex){
        MessageResponse error = MessageResponse.builder().messageError(ex.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }
}
