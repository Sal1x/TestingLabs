package implementations;

import Interfaces.ILogEvaluator;
import Interfaces.ITrigEvaluator;
import Interfaces.IFuncEvaluator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Function implements IFuncEvaluator {
    ITrigEvaluator trigEvaluator;
    ILogEvaluator logEvaluator;

    public Function(ITrigEvaluator trigEvaluator, ILogEvaluator logEvaluator) {
        this.trigEvaluator = trigEvaluator;
        this.logEvaluator = logEvaluator;
    }

    public Double compute(Double x, Double eps) {
        if (x.isNaN() || eps.isNaN() || x.isInfinite() || eps.isInfinite())
            return Double.NaN;
        else if (x > 0)
            return funcPos(x, eps);
        else
            return funcNeg(x, eps);
    }

    private Double funcNeg(Double x, Double eps) {
        return ((((Math.pow(trigEvaluator.csc(x, eps) / trigEvaluator.cos(x, eps), 2)
                * ((trigEvaluator.cos(x, eps) - trigEvaluator.sin(x, eps)) + (trigEvaluator.tan(x, eps) - trigEvaluator.sec(x, eps)))) *
                (trigEvaluator.sec(x, eps) - (trigEvaluator.cos(x, eps) + trigEvaluator.tan(x, eps)))) /
                (trigEvaluator.cos(x, eps) + trigEvaluator.csc(x, eps))));
    }

    private Double funcPos(Double x, Double eps) {
        return (((Math.pow(logEvaluator.ln(x, eps), 2) + logEvaluator.ln(x, eps)) +
                logEvaluator.log(x, 5.0, eps)) + logEvaluator.log(x, 5.0, eps)) -
                ((logEvaluator.log(x, 3.0, eps) + logEvaluator.log(x, 5.0, eps)) / logEvaluator.log(x, 5.0, eps));
    }

    public void printCsv(String filename, Double startX, Double step, Double endX) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(filename));

        pw.write("x,res\n");
        Double currX = startX;
        while (currX < endX) {
            pw.write(currX + "," + compute(currX,1E-6) + "\n");
            currX += step;
        }
        pw.close();
    }
}
