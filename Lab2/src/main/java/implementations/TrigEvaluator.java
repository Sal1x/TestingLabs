package implementations;

import Interfaces.ISin;
import Interfaces.ITrigEvaluator;

public class TrigEvaluator implements ITrigEvaluator {
    private final ISin sin;

    public TrigEvaluator(ISin sin) {
        this.sin = sin;
    }

    public Double sin(Double x, Double eps) {
        return sin.compute(x, eps);
    }

    public Double cos(Double x, Double eps) {
        return sin.compute(x + (Math.PI / 2), eps);
    }

    public Double tan(Double x, Double eps) {
        return sin.compute(x, eps) / sin.compute(x + (Math.PI / 2), eps);
    }

    public Double csc(Double x, Double eps) {
        return 1 / sin.compute(x, eps);
    }

    public Double sec(Double x, Double eps) {
        return 1 / sin.compute(x + (Math.PI / 2), eps);
    }
}
