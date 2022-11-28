package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.factory.ChessPieceFactory;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {

    @Test
    public void toStringTest() {
        final String expected = " Q  0  0  0  0  0  0  0 "+System.lineSeparator() +
                " 0  0  0  0  0  0  0  0 "+System.lineSeparator() +
                " 0  0  0  0  0  0  0  0 "+System.lineSeparator() +
                " 0  0  0  Q  0  0  0  0 "+System.lineSeparator() +
                " 0  0  0  0  0  0  0  0 "+System.lineSeparator() +
                " 0  0  Q  0  0  0  0  0 "+System.lineSeparator() +
                " 0  0  0  0  0  0  0  0 "+System.lineSeparator() +
                " 0  0  0  0  0  0  0  0 "+System.lineSeparator();

        ChessPiece a = ChessPieceFactory.createQueen(0, 0);
        ChessPiece b = ChessPieceFactory.createQueen(2, 5);
        ChessPiece c = ChessPieceFactory.createQueen(3, 3);

        ChessBoard board = new ChessBoard();
        board.addChessPiece(a);
        board.addChessPiece(b);
        board.addChessPiece(c);

        assertEquals(expected, board.toString());
    }

}