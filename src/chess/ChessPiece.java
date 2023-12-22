package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOponentPiece(Position p) {
        ChessPiece p = (ChessPiece) getBoard().pieces(position);
        return p != null && p.getColor() != color;
    }
}
