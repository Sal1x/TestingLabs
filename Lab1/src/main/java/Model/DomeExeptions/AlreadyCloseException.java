package Model.DomeExeptions;

public class AlreadyCloseException extends RuntimeException {
    public AlreadyCloseException(String message) {
        super(message);
    }
}
