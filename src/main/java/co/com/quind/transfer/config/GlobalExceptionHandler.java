package co.com.quind.transfer.config;


import co.com.quind.transfer.config.exception.ErrorResponse;
import co.com.quind.transfer.config.exception.GenericException;
import co.com.quind.transfer.config.exception.NotFoundException;
import co.com.quind.transfer.config.exception.SPError;
import co.com.quind.transfer.infrastructure.entrypoints.model.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Global exception handler for the application.
 * This class is annotated with {@link ControllerAdvice} to serve as a central point for handling exceptions
 * thrown across the entire application. It provides methods to handle different types of exceptions
 * and convert them into standardized {@link ErrorResponse} objects.
 *
 * <p>Each method in this class is annotated with {@link ExceptionHandler}, indicating the type of exception
 * it handles. The methods create an appropriate {@link ErrorResponse} and log the exception before returning
 * a {@link ResponseEntity} with the error details.</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericResponse> handleCustomException(GenericException ex) {
        GenericResponse error = GenericResponse.of(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),null);
        logError(error, ex);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> "Campo: "+error.getField()+" -> Error: "+error.getDefaultMessage())
                .collect(Collectors.toList());
        GenericResponse error = GenericResponse.of(HttpStatus.BAD_REQUEST.value(), SPError.INVALID_PARAMETERS.getErrorMessage(),errors);
        logError(error, ex);
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GenericResponse> handleMethodArgumentNotValid(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(GenericResponse.of(HttpStatus.NOT_FOUND.value(),ex.getMessage(),null));
    }


    private void logError(GenericResponse error, Exception ex) {
        logger.error("Error:{} -> Exception: {}", error, ex);
    }
}
