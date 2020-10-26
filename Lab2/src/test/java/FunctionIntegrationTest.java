import Interfaces.IFuncEvaluator;
import implementations.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static constants.Constants.eps;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionIntegrationTest {
    public static IFuncEvaluator function;

    @BeforeAll
    public static void prepare() {
        function = new Function(new TrigEvaluator(new Sin()), new LogEvaluator(new Ln()));
    }

    @Test
    public void oxIntersection() {
        assertEquals(0.0, function.compute(-6.283, eps), 0.01);
        assertEquals(0.0, function.compute(-12.566, eps), 0.01);
        assertEquals(0.0, function.compute(-18.849, eps), 0.01);
        assertEquals(0.0, function.compute(-37.699, eps), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "0.500,-3.53902",
            "2.5,0.42955",
            "3.500000,1.91397",
            "4.500000,3.17042",
            "6.000000,4.76375",
            "7.000000,5.68562",
            "-0.500000,1.24241",
            "-2.500000,3.76656",
            "-3.500000,-0.69926",
            "-4.400000,-2.59546",
            "-6.000000,0.04474",
            "-7.000000,6.02994"
    })
    public void resultCorrect(Double x, Double expected) {
        assertEquals(expected, function.compute(x, eps / 10), eps * 10);

    }
}
