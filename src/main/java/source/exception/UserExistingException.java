package source.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserExistingException extends RuntimeException {

    public UserExistingException(String message) {
        super(message);
    }

    public UserExistingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistingException(Throwable cause) {
        super(cause);
    }
}
