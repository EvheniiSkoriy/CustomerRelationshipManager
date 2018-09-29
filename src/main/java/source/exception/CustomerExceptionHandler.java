package source.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> exceptionHandler(CustomerNotFoundException exp){
        CustomerErrorResponse response =
                new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
                                          exp.getMessage(),
                                          System.currentTimeMillis());


        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> exceptionHandler(Exception exp){
        CustomerErrorResponse response =
                new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
                        exp.getMessage(),
                        System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
