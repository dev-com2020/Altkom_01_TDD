import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Test
    public void testCalcWithSpy() {
        Calculator calculator = new Calculator();
        Calculator calculatorSpy = spy(calculator);

        when(calculatorSpy.multiply(anyInt(),anyInt())).thenReturn(100);

        int additionResult = calculatorSpy.add(3,4);
        assertEquals(7,additionResult,"Metoda add() zwraca sumę rzeczywistą");

        int multiplicationResult = calculatorSpy.multiply(5,5);
        assertEquals(100,multiplicationResult,"Metoda multi powinna zwrócić symulowaną liczbę");

        verify(calculatorSpy).add(3,4);
        verify(calculatorSpy).multiply(5,5);
    }
}
