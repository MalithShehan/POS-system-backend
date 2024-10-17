package lk.ijse.gdse68.possystembackend.exception;

public class ItemNotFountException extends RuntimeException{
    public ItemNotFountException() {
        super();
    }

    public ItemNotFountException(String message) {
        super(message);
    }

    public ItemNotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
