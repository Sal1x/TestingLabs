import Interfaces.IFuncEvaluator;
import implementations.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        IFuncEvaluator function = new Function(new TrigEvaluator(new Sin()), new LogEvaluator(new Ln()));
        function.printCsv("result.csv", -10.0, 0.01, 10.0);
        System.out.println("Success");
    }
}
