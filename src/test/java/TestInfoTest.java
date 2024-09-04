import org.junit.jupiter.api.*;

import java.util.HashMap;

public class TestInfoTest {

    @BeforeEach
    void init(TestInfo testInfo){
        String displayName = testInfo.getDisplayName();
        System.out.printf("@BeforeEach %s %n", displayName);
    }

    @Test
    @DisplayName("Mój test")
    @Tag("my-tag")
    void testOne(TestInfo testInfo){
        System.out.println(testInfo.getTestMethod());
        System.out.println(testInfo.getTags());
        System.out.println(testInfo.getTestClass());
    }

    @RepeatedTest(2)
    void testTwo(RepetitionInfo repetitionInfo){
        System.out.println("** Test " + repetitionInfo.getCurrentRepetition()
        + "/" + repetitionInfo.getTotalRepetitions());
    }

    @Test
    void reportSingleValue(TestReporter testReporter){
        testReporter.publishEntry("key", "value");
    }

    @Test
    void reportSeveralValue(TestReporter testReporter){
        HashMap<String,String> values = new HashMap<>();
        values.put("name","jan");
        values.put("surname", "kowalski");
        testReporter.publishEntry(values);
    }
}
