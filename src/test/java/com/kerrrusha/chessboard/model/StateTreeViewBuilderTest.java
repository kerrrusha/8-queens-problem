package com.kerrrusha.chessboard.model;

import com.kerrrusha.nqueenproblem.stat.statetree.ChessBoardStateTree;
import com.kerrrusha.nqueenproblem.stat.statetree.StateTreeViewBuilder;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import org.graphstream.graph.Graph;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.kerrrusha.nqueenproblem.stat.statetree.factory.ChessBoardStateTreeFactory.getExampleStateTree;

public class StateTreeViewBuilderTest {

    @Test
    public void stateTreeDisplayTest() throws InterruptedException {
        ChessBoardStateTree tree = getExampleStateTree();

        Collection<Node<ChessBoard>> nodes = tree.getAllNodes();
        System.out.println("Collected " + nodes.size() + " nodes.");

        Graph graph = StateTreeViewBuilder.treeToGraph(tree);
        graph.display();

        Thread.sleep(60000);
    }
}
