import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ValueSourceTest {

    @ParameterizedTest
    @ValueSource(strings = { "hello", "world"})
    void testWithStrings(String argument){
        System.out.println("Test parametryzowany: " + argument);
        assertNotNull(argument);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    void testWithIntegers(int argument){
        System.out.println("Test parametryzowany: " + argument);
        assertNotNull(argument);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/MOCK_DATA.csv")
    void testWithCsvFile(String first_name, String last_name){
        System.out.println("Test parametryzowany: " + first_name + " " + last_name);
        assertNotNull(first_name);
    }

}
