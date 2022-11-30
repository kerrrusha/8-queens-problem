package com.kerrrusha.nqueenproblem.stat.statetree.algorithm;

import com.kerrrusha.nqueenproblem.stat.statetree.util.Node;
import com.kerrrusha.nqueenproblem.stat.statetree.util.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class BFSAlgorithm<T> {

    private final Tree<T> tree;

    public BFSAlgorithm(Tree<T> tree) {
        this.tree = tree;
    }

    public void doBFS() {
        Collection<Node<T>> nodesToTraverse = new ArrayList<>(List.of(tree.getRoot()));
        while (!nodesToTraverse.isEmpty()) {
            nodesToTraverse.forEach(this::doAction);
            nodesToTraverse = nodesToTraverse.stream()
                    .map(Node::getChildrens)
                    .flatMap(Collection::stream)
                    .collect(toCollection(ArrayList::new));
        }
    }

    private void doAction(Node<T> node) {
        System.out.println(node.getId());
    }
}
