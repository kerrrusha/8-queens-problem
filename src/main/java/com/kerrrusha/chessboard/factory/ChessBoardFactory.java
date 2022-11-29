package com.kerrrusha.chessboard.factory;

import com.kerrrusha.chessboard.model.ChessBoard;

public class ChessBoardFactory {

    public static ChessBoard getCopy(ChessBoard other) {
        final ChessBoard board = new ChessBoard();
        other.getChessPieces().stream()
                .map(ChessPieceFactory::getCopy)
                .forEach(board::addChessPiece);
        return board;
    }
}
