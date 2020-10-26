package tg;

public class Taylor {
    public static final double eps = 1E-9;
    public static double tg(double x) {
        int i = 1;
        double cos = 1, sin = x, intermediateValueCos = 1, intermediateValueSin = x;
        x = x % Math.PI;
        if (x % (Math.PI/2) == 0){
            throw new ArithmeticException();
        }
        while (Math.abs(intermediateValueCos *= -x * x / (2 * i * (2 * i - 1))) > eps
                && Math.abs(intermediateValueSin *= -x * x / (2 * i * (2 * i + 1))) > eps) {
            cos += intermediateValueCos;
            sin += intermediateValueSin;
            i++;
        }
        return sin / cos;
    }
}
