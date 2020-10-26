package implementations;

import Interfaces.ILn;
import Interfaces.ILogEvaluator;

public class LogEvaluator implements ILogEvaluator {
    private final ILn ln;

    public LogEvaluator(ILn ln) {
        this.ln = ln;
    }

    public Double ln(Double x, Double eps) {
        return ln.compute(x, eps);
    }

    public Double log(Double x, Double base, Double eps) {
        if (x.isNaN() || x.isInfinite() ||
                eps.isNaN() || eps.isInfinite() ||
                base.isNaN() || base.isInfinite())
            return Double.NaN;
        return ln.compute(x, eps / 100) / ln.compute(base, eps / 100);
    }
}
