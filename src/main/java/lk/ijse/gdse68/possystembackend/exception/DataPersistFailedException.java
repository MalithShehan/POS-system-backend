package lk.ijse.gdse68.possystembackend.exception;

public class DataPersistFailedException extends RuntimeException{
    public DataPersistFailedException() {
        super();
    }
    public DataPersistFailedException(String message) {
        super(message);
    }
    public DataPersistFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
