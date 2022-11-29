package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.factory.ChessBoardFactory;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Tree;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {

    @Test
    public void treeCountIsOkTest() {
        Tree<ChessBoard> tree = new Tree<>(ChessBoardFactory.getRandom());

        int rootId = tree.getRoot().getId();

        int level2_node1_id = tree.addNode(rootId, ChessBoardFactory.getRandom());
        int level2_node2_id = tree.addNode(rootId, ChessBoardFactory.getRandom());

        tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        tree.addNode(level2_node2_id, ChessBoardFactory.getRandom());

        assertEquals(6, tree.size());
    }

    @Test
    public void getAllNodesTest() {
        Tree<ChessBoard> tree = new Tree<>(ChessBoardFactory.getRandom());

        int rootId = tree.getRoot().getId();

        int level2_node1_id = tree.addNode(rootId, ChessBoardFactory.getRandom());
        int level2_node2_id = tree.addNode(rootId, ChessBoardFactory.getRandom());

        tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        tree.addNode(level2_node2_id, ChessBoardFactory.getRandom());

        Collection<Node<ChessBoard>> nodes = tree.getAllNodes();
        System.out.println("Collected " + nodes.size() + " nodes.");
        assertEquals(6, nodes.size());
    }
}
