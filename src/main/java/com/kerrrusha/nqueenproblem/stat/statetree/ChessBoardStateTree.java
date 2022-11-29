package com.kerrrusha.nqueenproblem.stat.statetree;

import com.kerrrusha.chessboard.model.ChessBoard;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Tree;

public class ChessBoardStateTree extends Tree<ChessBoard> {

    public ChessBoardStateTree() {}
    public ChessBoardStateTree(ChessBoard rootData) {
        root = new Node<>(rootData);
    }
}
