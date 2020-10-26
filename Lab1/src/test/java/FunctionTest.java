import org.junit.jupiter.api.Test;
import tg.Taylor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionTest {
    @Test
    public void UndefinedTan(){
        assertThrows(ArithmeticException.class, () -> Taylor.tg(Math.PI/2));
    }
    @Test
    public void MathTanEqual(){
        assertEquals(Math.tan(0.42), Taylor.tg(0.42), Taylor.eps);
        assertEquals(Math.tan(0.313), Taylor.tg(0.313), Taylor.eps);
        assertEquals(Math.tan(0.2), Taylor.tg(0.2), Taylor.eps);
        assertEquals(Math.tan(-0.5), Taylor.tg(-0.5), Taylor.eps);
    }
    @Test
    public void UndefinedTanSecond(){
        assertThrows(ArithmeticException.class, () -> Taylor.tg(Math.PI * (-3)/2));
    }
}
