package com.kerrrusha.nqueenproblem;

import com.kerrrusha.chessboard.analyzer.ChessBoardAnalyzer;
import com.kerrrusha.chessboard.factory.ChessBoardFactory;
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

    private int[] colsStartRowValues;

    public NQueenProblemSolver() {
        board = new ChessBoard();
        analyzer = new ChessBoardAnalyzer(board);
        stateTree = new ChessBoardStateTree();
        tracker = new AlgorithmNQueenStatTracker();
        colsStartRowValues = new int[board.getSize()];
    }

    public boolean solveNQueen(int col)
    {
        getStateTree().reset();
        int rootId = getStateTree().initRootNode(ChessBoardFactory.getEmpty());
        return solveNQueen(col, rootId);
    }

    private boolean solveNQueen(int col, int lastNodeId)
    {
        if (col >= board.getSize()) {
            return true;
        }

        getTracker().addStep();
        int createdNodeId = getStateTree().addNode(lastNodeId, ChessBoardFactory.getCopy(board));
        for (int i = getStartRow(col); i < board.getSize(); i++) {
            ChessPiece queen = ChessPieceFactory.getInstance(i, col);

            if (analyzer.isInSafe(queen)) {
                board.addChessPiece(queen);

                if (solveNQueen(col + 1, createdNodeId)) {
                    return true;
                }

                getTracker().addBacktrack();
                board.removeChessPiece(queen);
            }
        }
        return false;
    }

    public void setColsStartRowValues(int[] colsStartRowValues) {
        this.colsStartRowValues = colsStartRowValues;
    }

    private int getStartRow(int col) {
        return colsStartRowValues[col];
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
