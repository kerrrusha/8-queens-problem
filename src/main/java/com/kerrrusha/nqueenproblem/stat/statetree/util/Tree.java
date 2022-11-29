package com.kerrrusha.nqueenproblem.stat.statetree.util;

import java.util.Collection;
import java.util.Optional;

import static com.kerrrusha.nqueenproblem.stat.statetree.util.Node.UNKNOWN_ID;

public class Tree<T> {

    protected Node<T> root;

    public Tree() {}

    public Tree(T rootData) {
        root = new Node<>(rootData);
    }

    public Node<T> getRoot() {
        return root;
    }

    public int initRootNode(T nodeData) {
        if (root != null) {
            return UNKNOWN_ID;
        }
        root = new Node<>(nodeData);
        return root.getId();
    }

    public int addNode(int parentId, T nodeData) {
        if (root.getId() == parentId) {
            return root.addChild(nodeData);
        }

        Optional<Node<T>> found = findNode(parentId);
        if (found.isEmpty()) {
            return UNKNOWN_ID;
        }
        return found.get().addChild(nodeData);
    }

    public Optional<Node<T>> findNode(int id) {
        return getAllNodes().stream()
                .filter(node -> node.getId() == id)
                .findFirst();
    }

    public int size() {
        return root.getSubNodesCount();
    }

    public Collection<Node<T>> getAllNodes() {
        return root.getAllSubNodes();
    }
}
