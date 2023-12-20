package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardExcepition("Erro creating board: there is must be at 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece pieces(int row, int column) {
        if (!positionExist(row, column)) {
            throw new BoardExcepition("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece pieces(Position position) {
        if (!positionExist(position)) {
            throw new BoardExcepition("Position not on the board");
        }
        return pieces[position.getRow()][position.getCollum()];
    }

    public void placePiece(Piece piece, Position position) {
        if (therIsAPiece(position)) {
            throw new BoardExcepition("There is already a piece on this position");
        }
        pieces[position.getRow()][position.getCollum()] = piece;
        piece.position = position;
    }

    private boolean positionExist(int row, int column) {
        return row >= 0 && row < 0 && column >= 0 && column < 0;
    }

    public boolean positionExist(Position position) {
        return positionExist(position.getRow(), position.getCollum());
    }

    public boolean therIsAPiece(Position position) {
        if (!positionExist(position)) {
            throw new BoardExcepition("Position not on the board");
        }
        return pieces(position) != null;
    }
}
