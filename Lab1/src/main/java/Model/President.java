package Model;

public class President implements Human {
    public EnumMood mood;

    public President(){
        this.mood = EnumMood.SAD;
    }

    @Override
    public String reactToEvent() {
        this.mood = EnumMood.NORMAL;
        return "LOL";
    }

    public void pressTheButton(Dome dome){
        dome.open();
    }

}
