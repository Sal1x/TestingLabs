package Model.DomeExeptions;

public class AlreadyOpenException extends RuntimeException{
    public AlreadyOpenException(String message){
        super(message);
    }
}
