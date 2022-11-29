package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.factory.ChessPieceFactory;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @Test
    public void toStringTest() {
        final String expected = " Q  -  -  -  -  -  -  - "+System.lineSeparator() +
                " -  -  -  -  -  -  -  - "+System.lineSeparator() +
                " -  -  -  -  -  -  -  - "+System.lineSeparator() +
                " -  -  -  Q  -  -  -  - "+System.lineSeparator() +
                " -  -  -  -  -  -  -  - "+System.lineSeparator() +
                " -  -  Q  -  -  -  -  - "+System.lineSeparator() +
                " -  -  -  -  -  -  -  - "+System.lineSeparator() +
                " -  -  -  -  -  -  -  - "+System.lineSeparator();

        final Collection<ChessPiece> chessPieces = Arrays.asList(
                ChessPieceFactory.getInstance(0, 0),
                ChessPieceFactory.getInstance(2, 5),
                ChessPieceFactory.getInstance(3, 3)
        );

        ChessBoard board = new ChessBoard();
        chessPieces.forEach(board::addChessPiece);

        assertEquals(expected, board.toString());
    }

    @Test
    public void boardOverloadTest() {
        ChessBoard board = new ChessBoard();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.addChessPiece(ChessPieceFactory.getInstance(i, j));
            }
        }

        final int currentSize = board.getCurrentChessCount();
        board.addChessPiece(ChessPieceFactory.getInstance(0,0));
        assertEquals(currentSize, board.getCurrentChessCount());
    }
}