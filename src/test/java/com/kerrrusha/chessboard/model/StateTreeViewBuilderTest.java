package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.factory.ChessBoardFactory;
import com.kerrrusha.nqueenproblem.stat.statetree.ChessBoardStateTree;
import com.kerrrusha.nqueenproblem.stat.statetree.StateTreeViewBuilder;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import org.graphstream.graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class StateTreeViewBuilderTest {

    @Test
    public void stateTreeDisplayTest() throws InterruptedException {
        ChessBoardStateTree tree = getStateTree();

        Collection<Node<ChessBoard>> nodes = tree.getAllNodes();
        System.out.println("Collected " + nodes.size() + " nodes.");

        Graph graph = StateTreeViewBuilder.treeToGraph(tree);
        graph.display();

        Thread.sleep(60000);
    }

    private ChessBoardStateTree getStateTree() {
        ChessBoardStateTree tree = new ChessBoardStateTree(ChessBoardFactory.getRandom());

        int rootId = tree.getRoot().getId();

        int level2_node1_id = tree.addNode(rootId, ChessBoardFactory.getRandom());
        int level2_node2_id = tree.addNode(rootId, ChessBoardFactory.getRandom());

        tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        tree.addNode(level2_node2_id, ChessBoardFactory.getRandom());

        return tree;
    }
}
