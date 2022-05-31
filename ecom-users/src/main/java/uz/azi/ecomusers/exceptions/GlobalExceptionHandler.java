package uz.azi.ecomusers.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice("uz.azi.ecomusers")
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
}
