package lk.ijse.gdse68.possystembackend.exception;

public class CustomerNotFountException extends RuntimeException{
    public CustomerNotFountException() {
        super();
    }
    public CustomerNotFountException(String message) {
        super(message);
    }
    public CustomerNotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
