package dio.abel.springboot_jwt.infra;

import dio.abel.springboot_jwt.beans.Response;
import dio.abel.springboot_jwt.exceptions.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserException.class)
    public static ResponseEntity<?> userExceptionHandler(UserException userException) {
        var responseBody = errorResponse(userException);
        return ResponseEntity.status(userException.getStatusCode()).body(responseBody);
    }

    private static Response errorResponse(UserException userException) {
        return new Response(userException.getStatusCode(), userException.getMessage(), Instant.now());
    }
}
