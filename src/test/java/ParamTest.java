import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class ParamTest {

    @Parameter(0)
    public Integer input1;

    @Parameter(1)
    public String input2;

    @Parameters(name = "Mój test #{index} -- input data: {0} oraz {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{{1, "hello"}, {2, "goodbye"}}
        );
    }

    @Test
    public void test1(){
        System.out.println(input1 + " " + input2);
    }

}
