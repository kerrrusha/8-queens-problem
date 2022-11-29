package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.factory.ChessBoardFactory;
import com.kerrrusha.nqueenproblem.stat.statetree.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {

    @Test
    public void treeCountIsOkTest() {
        Tree<ChessBoard> tree = new Tree<>(ChessBoardFactory.getRandom());

        int rootId = tree.getRoot().getId();

        int level2_node1_id = tree.addNode(rootId, ChessBoardFactory.getRandom());
        int level2_node2_id = tree.addNode(rootId, ChessBoardFactory.getRandom());

        int level3_node1_id = tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        int level3_node2_id = tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        int level3_node3_id = tree.addNode(level2_node2_id, ChessBoardFactory.getRandom());

        assertEquals(6, tree.size());
    }
}
