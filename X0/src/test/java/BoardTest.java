import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.*;

/**
 * Created by mercutio on 06.06.17.
 */
public class BoardTest {

    @Test
    @DisplayName("Check if board can be instatiated")
    void testIfConstructorInstatiates() {
        Board board = new Board();
        assertEquals(Board.class, board.getClass());
    }

    @Nested
    class BoardInstatiated {

        Board testBoard;

        @BeforeEach
        void setUp() {
            testBoard = new Board();
        }

        @Test
        @DisplayName("Check if Board instatiates board of proper size")
        void testIfBoardCreatesProperedSizeArray() {
            testBoard.init();
            assertEquals(3, testBoard.getCells().length);
        }

        @Test
        @DisplayName("Check if Board has proper empty arrays")
        void testIfBoardCreatesProperEmptyBoard() {
            testBoard.init();
            assertAll("Check for cells position",
                    () -> assertEquals((Integer) 2, testBoard.getCells()[1][1].getCol(), "Test for second column."),
                    () -> assertEquals((Integer) 3, testBoard.getCells()[2][0].getRow(), "Test for second row."),
                    () -> assertEquals(Seed.EMPTY, testBoard.getCells()[1][0].getContent(), "Test if cell is empty"));
        }


    }

}