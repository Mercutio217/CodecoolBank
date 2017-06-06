import java.util.Arrays;

/**
 * Created by mercutio on 06.06.17.
 */
public class Board {

    Cell[][] cells;

    public Cell[][] getCells() {
        return cells;
    }

    public void init() {
        Cell[][] array = new Cell[3][3];
        for (int i = 1; i < 4; i++) {
            array[i - 1] = new Cell[]{new Cell(i , 1), new Cell(i, 2), new Cell(i, 3)};
        }
        cells = array;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.init();
    }
}
