import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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

    @DisabledOnOs({OS.MAC,OS.LINUX})
    @Test
    @Tag("simple")
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
    void assumeTrueTest(){
        assumeTrue(true);
    }

    @Test
    @Tag("display")
    @Tag("performance")
    @DisplayName("\uD83D\uDC80")
    void testWithDisplayNameContainingEmoji() {
        assertEquals(2, 2);
        assertTrue(true, "wiadomość");
        assertFalse(false, "wiadomość");
    }

    @Test
    void groupedAssertions() {
        assertAll("address", () -> assertEquals("John", "John"),
                () -> assertTrue(true, "wiadomość"));
    }

    @Test
    void groupedAssertions_tdd() {
        Address address = new Address("Jan", "Kowalski");
        assertAll("address", () -> assertEquals("Jan", address.getFirstName()),
                () -> assertEquals("Kowalski", address.getLastName()));
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("wiadomość");
        });
        assertEquals("wiadomość", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(2), () -> {
//            task
        });
    }

    @Test
    void timeoutExceeded() {
        assertTimeout(ofMillis(10), () -> {
            Thread.sleep(100);
        });
    }

    @Test
    void timeoutNotExceededWithResult(){
        String actualResult = assertTimeout(ofMinutes(1), () -> {
            return "cześć!";
        });
        assertEquals("cześć!", actualResult);
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
