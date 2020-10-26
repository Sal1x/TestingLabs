package Model;

public class Bureaucrat implements Human {
    public EnumMood mood;

    public Bureaucrat(){
        this.mood = EnumMood.ANNOY;
    }

    public Bureaucrat(EnumMood mood){
        this.mood = mood;
    }

    @Override
    public String reactToEvent() {
        return openMouth();
    }

    public String openMouth(){
        return "...";
    }
}
