/**
 * Created by mercutio on 06.06.17.
 */
public class Cell {
    private Integer row;
    private Integer col;
    private Seed content;

    public Cell(Integer row, Integer col) {
        setRow(row);
        setCol(col);
        this.content = Seed.EMPTY;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }

    public Seed getContent() {
        return content;
    }

    public void setRow(Integer row) {
        if (row > 3 || row < 1) {
            throw new IllegalArgumentException("Row cannot be smaller or bigger than board!");
        }
        this.row = row;
    }

    public void setCol(Integer col) {
        if (col > 3 || col < 1) {
            throw new IllegalArgumentException("Col cannot be smaller or bigger than board!");
        }
        this.col = col;
    }

    public void setContent(Seed content) {
        this.content = content;
    }

    public void clear() {
        setContent(Seed.EMPTY);
    }
}
