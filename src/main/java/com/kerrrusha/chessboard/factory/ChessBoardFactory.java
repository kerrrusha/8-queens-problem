package com.kerrrusha.chessboard.factory;

import com.kerrrusha.chessboard.model.ChessBoard;

import java.util.concurrent.ThreadLocalRandom;

public class ChessBoardFactory {

    public static ChessBoard getCopy(ChessBoard other) {
        final ChessBoard board = new ChessBoard();
        other.getChessPieces().stream()
                .map(ChessPieceFactory::getCopy)
                .forEach(board::addChessPiece);
        return board;
    }

    public static ChessBoard getEmpty() {
        return new ChessBoard();
    }

    public static ChessBoard getRandom() {
        final ChessBoard board = new ChessBoard();
        for (int i = 0; i < board.getSize(); i++) {
            int randCol = ThreadLocalRandom.current().nextInt(0, board.getSize());
            board.addChessPiece(ChessPieceFactory.getInstance(i, randCol));
        }
        return board;
    }
}
