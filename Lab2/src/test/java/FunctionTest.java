import Interfaces.IFuncEvaluator;
import Interfaces.ILogEvaluator;
import Interfaces.ITrigEvaluator;
import implementations.Function;
import org.junit.jupiter.api.Test;

import static constants.Constants.eps;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class FunctionTest {

    @Test
    public void positiveAreaCheck(){
        ILogEvaluator logEvalMock = mock(ILogEvaluator.class);
        when(logEvalMock.log(313.0, 3.0, eps)).thenReturn(1.0);
        when(logEvalMock.log(313.0, 5.0, eps)).thenReturn(1.0);
        when(logEvalMock.ln(313.0,  eps)).thenReturn(1.0);
        ITrigEvaluator trigEvalMock = mock(ITrigEvaluator.class);
        IFuncEvaluator funcEval = new Function(trigEvalMock, logEvalMock);

        funcEval.compute(313.0, eps);

        verify(logEvalMock, times(2)).ln(313.0,  eps);
        verify(logEvalMock, times(1)).log(313.0, 3.0,  eps);
        verify(logEvalMock, times(4)).log(313.0, 5.0,  eps);
    }

    @Test
    public void negativeAreaCheck(){
        ITrigEvaluator trigEvalMock = mock(ITrigEvaluator.class);
        when(trigEvalMock.sin(-313.0, eps)).thenReturn(-313.0);
        when(trigEvalMock.cos(-313.0, eps)).thenReturn(-313.0);
        when(trigEvalMock.csc(-313.0, eps)).thenReturn(-313.0);
        when(trigEvalMock.tan(-313.0, eps)).thenReturn(-313.0);
        when(trigEvalMock.sec(-313.0, eps)).thenReturn(-313.0);
        ILogEvaluator logEvalMock = mock(ILogEvaluator.class);
        IFuncEvaluator funcEval = new Function(trigEvalMock, logEvalMock);

        funcEval.compute(-313.0, eps);

        verify(trigEvalMock, times(1)).sin(-313.0, eps);
        verify(trigEvalMock, times(4)).cos(-313.0, eps);
        verify(trigEvalMock, times(2)).csc(-313.0, eps);
        verify(trigEvalMock, times(2)).tan(-313.0, eps);
        verify(trigEvalMock, times(2)).sec(-313.0, eps);
    }

    @Test
    public void validation() {
        ITrigEvaluator mockTrig = mock(ITrigEvaluator.class);
        ILogEvaluator mockLog = mock(ILogEvaluator.class);

        IFuncEvaluator f = new Function(mockTrig, mockLog);

        assertTrue(f.compute(Double.NaN, 1.0).isNaN());
        assertTrue(f.compute(Double.POSITIVE_INFINITY, 1.0).isNaN());
        assertTrue(f.compute(Double.NEGATIVE_INFINITY, 1.0).isNaN());
        assertTrue(f.compute(1.0, Double.NaN ).isNaN());
        assertTrue(f.compute(1.0, Double.POSITIVE_INFINITY).isNaN());
        assertTrue(f.compute(1.0, Double.NEGATIVE_INFINITY).isNaN());

        verify(mockTrig, never()).sin(anyDouble(), anyDouble());
        verify(mockTrig, never()).cos(anyDouble(), anyDouble());
        verify(mockTrig, never()).csc(anyDouble(), anyDouble());
        verify(mockTrig, never()).tan(anyDouble(), anyDouble());
        verify(mockTrig, never()).sec(anyDouble(), anyDouble());
        verify(mockLog, never()).log(anyDouble(), anyDouble(), anyDouble());
        verify(mockLog, never()).ln(anyDouble(), anyDouble());
    }
}
