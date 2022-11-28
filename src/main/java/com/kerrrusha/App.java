package com.kerrrusha;

import com.kerrrusha.chessboard.factory.ChessPieceFactory;
import com.kerrrusha.chessboard.model.ChessBoard;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;

public class App {

    public static void main(String[] args) {
        ChessPiece a = ChessPieceFactory.createQueen(0, 0);
        ChessPiece b = ChessPieceFactory.createQueen(2, 5);
        ChessPiece c = ChessPieceFactory.createQueen(3, 3);

        ChessBoard board = new ChessBoard();
        board.addChessPiece(a);
        board.addChessPiece(b);
        board.addChessPiece(c);

        System.out.println(board);
    }
}
