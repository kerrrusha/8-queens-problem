package com.kerrrusha.chessboard.model;

import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Tree;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.kerrrusha.nqueenproblem.stat.statetree.factory.ChessBoardStateTreeFactory.getExampleStateTree;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeTest {

    @Test
    public void treeCountIsOkTest() {
        Tree<ChessBoard> tree = getExampleStateTree();

        assertEquals(17, tree.size());
    }

    @Test
    public void getAllNodesTest() {
        Tree<ChessBoard> tree = getExampleStateTree();

        Collection<Node<ChessBoard>> nodes = tree.getAllNodes();
        System.out.println("Collected " + nodes.size() + " nodes.");
        assertEquals(17, nodes.size());
    }
}
