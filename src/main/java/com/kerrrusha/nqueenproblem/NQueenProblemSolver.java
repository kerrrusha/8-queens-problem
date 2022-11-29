package com.kerrrusha.nqueenproblem;

import com.kerrrusha.chessboard.analyzer.ChessBoardAnalyzer;
import com.kerrrusha.chessboard.factory.ChessPieceFactory;
import com.kerrrusha.chessboard.model.ChessBoard;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;
import com.kerrrusha.nqueenproblem.stat.AlgorithmNQueenStatTracker;
import com.kerrrusha.nqueenproblem.stat.statetree.ChessBoardStateTree;

public class NQueenProblemSolver {

    private final ChessBoard board;
    private final ChessBoardAnalyzer analyzer;
    private final ChessBoardStateTree stateTree;
    private final AlgorithmNQueenStatTracker tracker;

    public NQueenProblemSolver() {
        board = new ChessBoard();
        analyzer = new ChessBoardAnalyzer(board);
        stateTree = new ChessBoardStateTree();
        tracker = new AlgorithmNQueenStatTracker();
    }

    public boolean solveNQueen(int col)
    {
        if (col >= board.getSize()) {
            return true;
        }

        getTracker().addStep();
        //stateTree.addNode(ChessBoardFactory.getCopy(board));
        for (int i = 0; i < board.getSize(); i++) {
            ChessPiece queen = ChessPieceFactory.getInstance(i, col);

            if (analyzer.isInSafe(queen)) {
                board.addChessPiece(queen);

                if (solveNQueen(col + 1)) {
                    return true;
                }

                getTracker().addBacktrack();
                board.removeChessPiece(queen);
            }
        }
        return false;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public AlgorithmNQueenStatTracker getTracker() {
        return tracker;
    }

    public ChessBoardStateTree getStateTree() {
        return stateTree;
    }
}
