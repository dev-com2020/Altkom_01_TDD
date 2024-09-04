import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestTest {

    @BeforeEach
    void setup1(){
        System.out.println("Setup 1");
    }

    @RepeatedTest(value = 2, name = "{displayName} = {currentRepetition}/{totalRepetitions}")
    @DisplayName("Powtórka!")
    void topTest(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName());
        System.out.println("Test 1");
        assertEquals(2, 2);
    }

    @Nested
    class InnerClass1 {
        @BeforeEach
        void setup2(){
            System.out.println("Setup 2");
        }
        @Test
        void innerTest1() {
            System.out.println("Test 2");
            assertEquals(2, 2);
        }
        @Nested
        class InnerClass2 {
            @Test
            void innerTest2(){
                System.out.println("Test 3");
            }
        }
    }
}
