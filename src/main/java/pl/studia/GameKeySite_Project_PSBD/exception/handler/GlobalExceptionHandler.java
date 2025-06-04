package pl.studia.GameKeySite_Project_PSBD.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import pl.studia.GameKeySite_Project_PSBD.exception.InvalidEnumException;
import pl.studia.GameKeySite_Project_PSBD.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationErrorDto validationErrorDto = new ValidationErrorDto();
        e.getFieldErrors().forEach(error -> validationErrorDto.addViolation(error.getField(), error.getDefaultMessage()));
        return validationErrorDto;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoResourceFoundException.class)
    public ExceptionDto handleNoResourceFoundException(NoResourceFoundException e) {
        return new ExceptionDto("resource not found, wrong path: " + e.getResourcePath());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvalidEnumException.class)
    public ExceptionDto handleInvalidEnumException(InvalidEnumException e) {
        return new ExceptionDto(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionDto handleNotFoundException(NotFoundException e) {
        return new ExceptionDto(e.getMessage());
    }
}
