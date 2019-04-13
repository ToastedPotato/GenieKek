package place;

public class Seat extends Place{

    private int row;
    private Column column;

    public Seat(int row, Column column) {
        super(24);
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }
}
