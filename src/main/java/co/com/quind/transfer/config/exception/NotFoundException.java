package co.com.quind.transfer.config.exception;

public class NotFoundException extends GenericException{
    public NotFoundException(int errorCode, String message) {
        super(errorCode, message);
    }
}
