package com.kerrrusha.nqueenproblem.stat.statetree.factory;

import com.kerrrusha.chessboard.factory.ChessBoardFactory;
import com.kerrrusha.nqueenproblem.stat.statetree.ChessBoardStateTree;

public class ChessBoardStateTreeFactory {

    public static ChessBoardStateTree getExampleStateTree() {
        ChessBoardStateTree tree = new ChessBoardStateTree(ChessBoardFactory.getRandom());

        int rootId = tree.getRoot().getId();

        int level2_node1_id = tree.addNode(rootId, ChessBoardFactory.getRandom());
        int level2_node2_id = tree.addNode(rootId, ChessBoardFactory.getRandom());

        int level3_node1_id = tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        int level3_node2_id = tree.addNode(level2_node1_id, ChessBoardFactory.getRandom());
        int level3_node3_id = tree.addNode(level2_node2_id, ChessBoardFactory.getRandom());
        int level3_node4_id = tree.addNode(level2_node2_id, ChessBoardFactory.getRandom());
        int level3_node5_id = tree.addNode(level2_node2_id, ChessBoardFactory.getRandom());

        tree.addNode(level3_node1_id, ChessBoardFactory.getRandom());
        tree.addNode(level3_node1_id, ChessBoardFactory.getRandom());
        tree.addNode(level3_node2_id, ChessBoardFactory.getRandom());
        tree.addNode(level3_node3_id, ChessBoardFactory.getRandom());
        tree.addNode(level3_node3_id, ChessBoardFactory.getRandom());
        tree.addNode(level3_node3_id, ChessBoardFactory.getRandom());
        tree.addNode(level3_node4_id, ChessBoardFactory.getRandom());
        tree.addNode(level3_node4_id, ChessBoardFactory.getRandom());
        tree.addNode(level3_node5_id, ChessBoardFactory.getRandom());

        return tree;
    }
}
