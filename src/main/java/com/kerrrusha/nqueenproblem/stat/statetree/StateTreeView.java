package com.kerrrusha.nqueenproblem.stat.statetree;

import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Tree;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class StateTreeView <T> {

    private final Tree<T> tree;
    private final Graph graph;

    public StateTreeView(Tree<T> tree) {
        this.tree = tree;
        this.graph = new SingleGraph("State Tree");
        treeToGraph();
    }

    public void display() {
        graph.display();
    }

    private void treeToGraph() {
        addNodes(tree);
        addEdges(tree);
    }

    private void addNodes(Tree<T> tree) {
        for (Node<T> node : tree.getAllNodes()) {
            graph.addNode(node.getId() + "");
        }
    }

    private void addEdges(Tree<T> tree) {
        for (Node<T> node : tree.getAllNodes()) {
            node.getChildrens()
                    .forEach(child -> graph.addEdge(node.getId() + "-" + child.getId(),
                            node.getId() + "",
                            child.getId() + ""));
        }
    }
}
