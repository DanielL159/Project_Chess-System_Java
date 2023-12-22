package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRow() - 1, position.getCollum());
        while (getBoard().positionExist(p) && getBoard().therIsAPiece(p)) {
            mat[p.getRow()][p.getCollum()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExist(p) && isThereOponentPiece(p)) {
            mat[p.getRow()][p.getCollum()] = true;
        }
        //left row
        p.setValues(position.getRow(), position.getCollum() - 1);
        while (getBoard().positionExist(p) && getBoard().therIsAPiece(p)) {
            mat[p.getRow()][p.getCollum()] = true;
            p.setCollum(p.getCollum() - 1);
        }
        if (getBoard().positionExist(p) && isThereOponentPiece(p)) {
            mat[p.getRow()][p.getCollum()] = true;
        }
        //Rigth
        p.setValues(position.getRow(), position.getCollum() + 1);
        while (getBoard().positionExist(p) && getBoard().therIsAPiece(p)) {
            mat[p.getRow()][p.getCollum()] = true;
            p.setCollum(p.getCollum() + 1);
        }
        if (getBoard().positionExist(p) && isThereOponentPiece(p)) {
            mat[p.getRow()][p.getCollum()] = true;
        }
        //below
        //above
        p.setValues(position.getRow() + 1, position.getCollum());
        while (getBoard().positionExist(p) && getBoard().therIsAPiece(p)) {
            mat[p.getRow()][p.getCollum()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExist(p) && isThereOponentPiece(p)) {
            mat[p.getRow()][p.getCollum()] = true;
        }
        return mat;
    }
}
