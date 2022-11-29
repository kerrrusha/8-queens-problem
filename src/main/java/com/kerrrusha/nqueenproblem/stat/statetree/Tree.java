package com.kerrrusha.nqueenproblem.stat.statetree;

import java.util.Optional;

import static com.kerrrusha.nqueenproblem.stat.statetree.Node.UNKNOWN_ID;

public class Tree<T> {

    private final Node<T> root;

    public Tree(T rootData) {
        root = new Node<>(rootData);
    }

    public Node<T> getRoot() {
        return root;
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
        return root.findChild(id);
    }

    public int size() {
        return root.getSubNodesCount();
    }
}
