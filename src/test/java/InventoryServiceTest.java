import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InventoryServiceTest {

    private InventoryService inventoryService;

    @BeforeEach
    void setUp() {
        inventoryService = new InventoryService();
    }

    @Nested
    @DisplayName("Add Stock Tests")
    class AddStockTests {

        @ParameterizedTest
        @CsvSource({
                "Product A, 10,5,15",
                "Product B, 0,20,20",
                "Product C, 5,10,15",
        })
        @DisplayName("Should add stock correctly")
        void shouldAddStockCorrectly(String product, int initalQuantity,
                                     int additionalQuantity, int expectedTotalQuantity) {
//            Arrange
            inventoryService.addStock(product, initalQuantity);
//            Act
            inventoryService.addStock(product, additionalQuantity);
//            Assert
            assertEquals(expectedTotalQuantity, inventoryService.getStock(product));
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -5})
        @DisplayName("Should throw exception when adding zero or negative stock")
        void shouldThrowExceptionWhenAddingZeroOrNegativeStock(int quantity) {
//            Act & Assert
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> inventoryService.addStock("Product A", quantity)
            );
            assertEquals("Quantity must be greater than zero", exception.getMessage());
        }

        @Nested
        @DisplayName("Rmove Stock Tests")
        class RemoveStockTests {

            @ParameterizedTest
            @CsvSource({
                    "Product A, 10,5,5",
                    "Product B, 20,10,10",
                    "Product C, 10,10,0",
            })
            @DisplayName("Should remove stock correctly")
            void shouldRemoveStockCorrectly(String product, int initalQuantity,
                                            int removeQuantity, int expectedRemainingQuantity) {
//            Arrange
                inventoryService.addStock(product, initalQuantity);
//            Act
                inventoryService.removeStock(product, removeQuantity);
//            Assert
                assertEquals(expectedRemainingQuantity, inventoryService.getStock(product));
            }

            @ParameterizedTest
            @ValueSource(ints = {0, -5})
            @DisplayName("Should throw exception when removing zero or negative stock")
            void shouldThrowExceptionWhenRemovingZeroOrNegativeStock(int quantity) {
//            Act & Assert
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> inventoryService.removeStock("Product A", quantity)
                );
                assertEquals("Quantity must be greater than zero", exception.getMessage());
            }
        }

        @Test
        void shouldReturnZeroStockForNonExistentProduct() {
//            Act & Assert
            assertEquals(0,inventoryService.getStock(null));
        }
    }
}
