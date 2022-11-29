package com.kerrrusha.nqueenproblem;

import com.kerrrusha.chessboard.model.ChessBoard;

import java.util.ArrayList;
import java.util.Collection;

public class ChessBoardStateTree {

    private final Collection<ChessBoard> tree = new ArrayList<>();

    public void addNode(ChessBoard node) {
        tree.add(node);
    }

    @Override
    public String toString() {
        return "ChessBoardStateTree{" +
                "tree=" + tree +
                '}';
    }
}
