import Model.*;
import Model.DomeExeptions.AlreadyCloseException;
import Model.DomeExeptions.AlreadyOpenException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DomainTest {
    @Test
    public void bureaucratSetMood(){
        Bureaucrat bureaucrat = new Bureaucrat(EnumMood.HAPPY);
        assertEquals(EnumMood.HAPPY, bureaucrat.mood);
    }

    @Test
    public void bureaucratActionReaction(){
        Bureaucrat bureaucrat = new Bureaucrat();
        assertEquals(EnumMood.ANNOY, bureaucrat.mood);

        assertEquals("...", bureaucrat.openMouth());

        assertEquals("...", bureaucrat.reactToEvent());

    }

    @Test
    public void presidentTesting(){
        President president = new President();
        assertEquals(EnumMood.SAD, president.mood);

        assertEquals("LOL", president.reactToEvent());
        assertEquals(EnumMood.NORMAL, president.mood);
    }

    @Test
    public void DomeTesting(){
        Dome dome = new Dome();
        assertEquals(EnumDomeState.CLOSED, dome.state);

        President president = new President();
        president.pressTheButton(dome);
        assertEquals(EnumDomeState.OPENED, dome.state);

        assertThrows(AlreadyOpenException.class,() -> president.pressTheButton(dome) );

        dome.close();
        assertEquals(EnumDomeState.CLOSED, dome.state);

        assertThrows(AlreadyCloseException.class, () -> dome.close());

    }
}
