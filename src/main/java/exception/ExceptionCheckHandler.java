package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionCheckHandler {
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		e.printStackTrace();
		return "/error/exceptionCheck";
	}
}
