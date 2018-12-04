package pl.sda.jdbc.jdbc.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "pl.sda.jdbc.jdbc.rest")
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RestPokemonException.class})
    public ResponseEntity<Object> handleRestPokemon(Exception e, WebRequest webRequest){
        String errorText= "Coundn't add new Pokemon";

      return handleExceptionInternal(e,errorText, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);

    }
    @ExceptionHandler(value = {RestNotFoundException.class})
    public ResponseEntity<Object> handleRestNotFoundPokemon(Exception e, WebRequest webRequest){
        String errorText= "Coundn't found Pokemon";

        return handleExceptionInternal(e,errorText, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);

    }
}
