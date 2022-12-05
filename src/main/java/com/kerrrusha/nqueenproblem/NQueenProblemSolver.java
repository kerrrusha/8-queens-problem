package com.kerrrusha.nqueenproblem;

import com.kerrrusha.chessboard.analyzer.ChessBoardAnalyzer;
import com.kerrrusha.chessboard.factory.ChessBoardFactory;
import com.kerrrusha.chessboard.factory.ChessPieceFactory;
import com.kerrrusha.chessboard.model.ChessBoard;
import com.kerrrusha.chessboard.model.chesspiece.ChessPiece;
import com.kerrrusha.nqueenproblem.stat.AlgorithmNQueenStatTracker;
import com.kerrrusha.nqueenproblem.stat.statetree.ChessBoardStateTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class NQueenProblemSolver {

    private final ChessBoard board;
    private final ChessBoardAnalyzer analyzer;
    private final ChessBoardStateTree stateTree;
    private final AlgorithmNQueenStatTracker tracker;

    private int[] initState;

    public NQueenProblemSolver() {
        board = new ChessBoard();
        analyzer = new ChessBoardAnalyzer(board);
        stateTree = new ChessBoardStateTree();
        tracker = new AlgorithmNQueenStatTracker();
        initState = new int[board.getSize()];
    }

    public boolean doRBFSAlgorithm(int col)
    {
        getStateTree().reset();
        int rootId = getStateTree().initRootNode(ChessBoardFactory.getEmpty());
        return doRBFSAlgorithm(col, rootId);
    }

    private boolean doRBFSAlgorithm(int col, int lastNodeId)
    {
        if (col >= board.getSize()) {
            return true;
        }

        getTracker().addStep();
        int createdNodeId = getStateTree().addNode(lastNodeId, ChessBoardFactory.getCopy(board));
        for (int i = getInitState(col); i < board.getSize(); i++) {
            ChessPiece queen = ChessPieceFactory.getInstance(i, col);

            if (analyzer.isInSafe(queen)) {
                board.addChessPiece(queen);

                if (doRBFSAlgorithm(col + 1, createdNodeId)) {
                    return true;
                }

                getTracker().addBacktrack();
                board.removeChessPiece(queen);
            }
        }
        return false;
    }

    public int[] getSolvedState() {
        Collection<Integer> rows = new ArrayList<>();
        board.getChessPieces().stream()
                .sorted(Comparator.comparingInt(p -> p.getCoords().x))
                .forEach(chessPiece -> rows.add(chessPiece.getCoords().y));
        return rows.stream().mapToInt(x -> x).toArray();
    }

    public void setInitState(int[] initState) {
        this.initState = initState;
    }

    private int getInitState(int col) {
        return initState[col];
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
