package com.kerrrusha.nqueenproblem;

import com.kerrrusha.chessboard.analyzer.ChessBoardAnalyzer;
import com.kerrrusha.chessboard.factory.ChessPieceFactory;
import com.kerrrusha.chessboard.model.ChessBoard;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;

public class NQueenProblemSolver {

    private final ChessBoard board;
    private final ChessBoardAnalyzer analyzer;

    public NQueenProblemSolver() {
        board = new ChessBoard();
        analyzer = new ChessBoardAnalyzer(board);
    }

    public boolean solveNQueen(int col)
    {
        if (col >= board.getSize()) {
            return true;
        }

        for (int i = 0; i < board.getSize(); i++) {
            ChessPiece queen = ChessPieceFactory.createQueen(i, col);

            if (analyzer.isInSafe(queen)) {
                board.addChessPiece(queen);

                if (solveNQueen(col + 1)) {
                    return true;
                }

                board.removeChessPiece(queen);
            }
        }
        return false;
    }

    public ChessBoard getBoard() {
        return board;
    }
}
