package Model;


import Model.DomeExeptions.AlreadyCloseException;
import Model.DomeExeptions.AlreadyOpenException;
import Model.DomeExeptions.ClosingException;

public class Dome {
    public EnumDomeState state;

    public Dome(){
        this.state = EnumDomeState.CLOSED;
    }

    public void open(){
        if(this.state == EnumDomeState.OPENED){
            throw new AlreadyOpenException("Уже открыто");
        }
        this.state = EnumDomeState.OPENED;
    }

    public void close() {
        if(this.state == EnumDomeState.CLOSED)
            throw new AlreadyCloseException("Уже закрыто");

        this.state = EnumDomeState.CLOSED;
    }

}
