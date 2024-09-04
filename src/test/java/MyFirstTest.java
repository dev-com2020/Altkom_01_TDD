import org.junit.jupiter.api.*;

public class MyFirstTest {

    @BeforeAll
    static void setupAll() {
        System.out.println("Setup ALL TESTS in the class");
    }

    @BeforeEach
    void setup() {
        System.out.println("Setup EACH TEST in the class");
    }

    @Test
    void mySimpleTest() {
        System.out.println("TEST 1");
    }

    @Test
    void mySimpleTest2() {
        System.out.println("TEST 2");

    }

    @Test
    void mySimpleTest3() {
        System.out.println("TEST 3");
    }

    @AfterEach
    void teardown() {
        System.out.println("Teardown EACH TEST in the class");
    }

    @AfterAll
    static void teardownAll() {
        System.out.println("Teardown ALL TEST in the class");
    }
}
