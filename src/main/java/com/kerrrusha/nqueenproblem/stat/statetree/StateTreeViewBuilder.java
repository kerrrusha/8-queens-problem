package com.kerrrusha.nqueenproblem.stat.statetree;

import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Tree;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class StateTreeViewBuilder {

    public static Graph treeToGraph(ChessBoardStateTree tree) {
        Graph graph = new SingleGraph("State Tree");

        addNodes(graph, tree);
        addEdges(graph, tree);

        return graph;
    }

    private static <T> void addNodes(Graph graph, Tree<T> tree) {
        for (Node<T> node : tree.getAllNodes()) {
            graph.addNode(node.getId() + "");
        }
    }

    private static <T> void addEdges(Graph graph, Tree<T> tree) {
        for (Node<T> node : tree.getAllNodes()) {
            node.getChildrens()
                    .forEach(child -> graph.addEdge(node.getId() + "-" + child.getId(),
                            node.getId() + "",
                            child.getId() + ""));
        }
    }
}
