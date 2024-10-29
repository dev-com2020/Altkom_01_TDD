import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Calculator.class)
public class CalculatorPowerTest {

    @Test
    public void testPowerCalcWithSpy() throws Exception {
        Calculator calculator = PowerMockito.spy(new Calculator());

        when(calculator, "calculateSum", 2,3).thenReturn(10);

        int result = calculator.addNumbers(2,3);

        assertEquals(10, result);

        PowerMockito.verifyPrivate(calculator).invoke("calculateSum",2,3);
    }
}

