package dio.abel.springboot_jwt.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends RuntimeException {
    private int statusCode = 400;
    public UserException(String message) {
        super(message);
    }
    public UserException(int statusCode, String message) {super(message); this.statusCode = statusCode;}
}
