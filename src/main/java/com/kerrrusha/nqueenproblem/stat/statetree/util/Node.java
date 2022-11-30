package com.kerrrusha.nqueenproblem.stat.statetree.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class Node<T> {

    public static final int UNKNOWN_ID = -1;

    private static int nodeCreated = 0;

    private final int id;
    private final T data;
    private final Node<T> parent;
    private final Collection<Node<T>> childrens;

    public Node(T data) {
        this.data = data;
        childrens = new ArrayList<>();
        parent = null;

        nodeCreated += 1;
        id = nodeCreated;
    }

    public int addChild(T nodeData) {
        final Node<T> node = new Node<>(nodeData);
        childrens.add(node);
        return node.getId();
    }

    public int getSubNodesCount() {
        int result = 1;

        result += childrens.stream()
                .map(Node::getSubNodesCount)
                .mapToInt(Integer::intValue)
                .sum();

        return result;
    }

    public Collection<Node<T>> getAllSubNodes() {
        Collection<Node<T>> nodes = new ArrayList<>(List.of(this));
        nodes.addAll(getChildrens().stream()
                .map(Node::getAllSubNodes)
                .flatMap(Collection::stream)
                .collect(toCollection(ArrayList::new)));
        return nodes;
    }

    public int getId() {
        return id;
    }

    public T getData() {
        return data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public Collection<Node<T>> getChildrens() {
        return childrens;
    }
}
