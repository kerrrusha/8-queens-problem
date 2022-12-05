package com.kerrrusha.nqueenproblem.stat.statetree.algorithm;

import com.kerrrusha.chessboard.analyzer.ChessBoardAnalyzer;
import com.kerrrusha.chessboard.model.ChessBoard;
import com.kerrrusha.nqueenproblem.NQueenProblemSolver;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Tree;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class BFSAlgorithm<T> {

    private static final Logger logger = Logger.getLogger(BFSAlgorithm.class);

    private final Tree<T> tree;

    public BFSAlgorithm(Tree<T> tree) {
        this.tree = tree;
        solveTask();
    }

    private void solveTask() {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        solver.setInitState(((ChessBoard)tree.getRoot().getData()).getState());
        solver.doRBFSAlgorithm(0);
    }

    public void doBFS() {
        Collection<Node<T>> nodesToTraverse = new ArrayList<>(List.of(tree.getRoot()));
        while (!nodesToTraverse.isEmpty()) {
            nodesToTraverse.forEach(this::doAction);
            nodesToTraverse = nodesToTraverse.stream()
                    .map(Node::getChildrens)
                    .flatMap(Collection::stream)
                    .collect(toCollection(ArrayList::new));
        }
    }

    private void doAction(Node<T> node) {
        try {
            ChessBoard board = (ChessBoard) node.getData();
            boolean nodeIsOk = new ChessBoardAnalyzer(board).getChessPiecesUnderAttack().isEmpty();
            logger.debug("BFS traversing node with id=" + node.getId() + " and state=" + Arrays.toString(board.getState()));
            assert nodeIsOk;
            board.getChessPieces().forEach(chessPiece -> {
                assert new ChessBoardAnalyzer(board).isInSafe(chessPiece);
            });
        } catch (Throwable e) {
            logger.warn(e);
        }
    }
}
