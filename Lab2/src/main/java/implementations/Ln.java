package implementations;


import static java.lang.Math.abs;

public class Ln implements Interfaces.ILn {
    public Double compute(Double x, Double eps) {
        if (x.isNaN() || x.isInfinite() || x <= 0 || eps.isNaN() || eps.isInfinite())
            return Double.NaN;
        return log(x, eps);
    }

    private Double log(Double x, Double eps) {
        Double num = (x - 1) / (x + 1);
        return l(num, eps, num, 3.0, 0.0);
    }

    private Double l(Double x1, Double eps, Double cur, Double n, Double res) {
        if (abs(cur) < eps)
            return res;
        return l(x1, eps, cur * x1 * x1 / n * (n - 2), n + 2, res + 2 * cur);
    }
}
