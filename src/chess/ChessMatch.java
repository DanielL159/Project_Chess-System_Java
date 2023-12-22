package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mt = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mt[i][j] = (ChessPiece) board.pieces(i, j);
            }
        }
        return mt;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.pieces(position).possibleMoves();
    }

    public ChessPiece performeChessMove(ChessPosition sourcePosition, ChessPosition targetePosition) {
        Position sorce = sourcePosition.toPosition();
        Position target = targetePosition.toPosition();
        validateSourcePosition(sorce);
        validateTargetPosition(sorce, target);
        Piece capturedePiece = makeMove(sorce, target);
        return (ChessPiece) capturedePiece;
    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece captured = board.removePiece(target);
        board.placePiece(p, target);
        return captured;
    }

    private void validateSourcePosition(Position position) {
        if (!board.therIsAPiece(position)) {
            throw new ChessExcepition("There is no piece on source position ");
        }
        if (!board.pieces(position).isThereAnyPossibleMove()) {
            throw new ChessExcepition("There isn't possible moves");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.pieces(source).possibleMove(target)) {
            throw new ChessExcepition("The chosen piece can't move to target position");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
