import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertThrows;

/**
 * Created by mercutio on 06.06.17.
 */
public class CellTest {

    @Test
    @DisplayName("Let's check if Cell constructor instatiates proper row and col.")
    void testIfCellConstructorInstatiatesProperly() {
        Cell cell = new Cell(1, 2);
        assertAll("Check if constructor is valid",
                () -> assertEquals((Integer) 1, cell.getRow()),
                () -> assertEquals((Integer) 2, cell.getCol()));
    }


    @DisplayName("When instatiated")
    @Nested
    class CellTestInstatiated {

        Cell testCell;

        @BeforeEach
        void setUp() {
            testCell = new Cell(1, 2);
        }

        @Test
        @DisplayName("Check if content is instatiated")
        void testIfContentIsInstatiated() {
            assertEquals(Seed.class, testCell.getContent().getClass());
        }

        @Test
        @DisplayName("Check if content is instatiated with EMPTY value")
        void testIfContentIsInstatiatedWithEmpty() {
            assertEquals(Seed.EMPTY, testCell.getContent());
            }

        @Test
        @DisplayName("Check if clear() clears cell object from values")
        void testIfClearClearsObjectFromValues() {
            testCell.setContent(Seed.CROSS);
            testCell.clear();
            assertEquals(Seed.EMPTY, testCell.getContent());

        }

        @Test
        @DisplayName("Test if Cell can take non standard values")
        void testIfCellCanTakeNonStandardValues() {
        assertThrows(IllegalArgumentException.class, () -> testCell.setRow(4));

    }


}
}
