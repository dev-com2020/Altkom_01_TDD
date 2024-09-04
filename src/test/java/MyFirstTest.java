import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//@Disabled("All test in the class wiil be skipped")
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
    @DisplayName("Custom test name containing spaces")
    void mySimpleTest() {
        System.out.println("TEST 1");
    }

    @Disabled
    @Test
    void mySimpleTest2() {
        System.out.println("TEST 2");

    }

    @Test
    @DisplayName("\uD83D\uDC80")
    void testWithDisplayNameContainingEmoji() {
        assertEquals(2,2);
        assertTrue(true,"wiadomość");
        assertFalse(false,"wiadomość");
    }

    @Test
    void groupedAssertions(){
        assertAll("address", () -> assertEquals("John","John"),
                () -> assertTrue(true,"wiadomość"));
    }

    @Test
    void groupedAssertions_tdd(){
        Address address = new Address("Jan", "Kowalski");
        assertAll("address", () -> assertEquals("Jan",address.getFirstName()),
                () -> assertEquals("Kowalski", address.getLastName()));
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
