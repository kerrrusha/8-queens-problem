package com.kerrrusha.chessboard.model;

import com.kerrrusha.nqueenproblem.stat.statetree.algorithm.BFSAlgorithm;
import org.junit.jupiter.api.Test;

import static com.kerrrusha.nqueenproblem.stat.statetree.factory.ChessBoardStateTreeFactory.getExampleStateTree;

public class BFSAlgorithmTest {

    @Test
    public void doBFSTest() {
        new BFSAlgorithm<>(getExampleStateTree()).doBFS();
    }
}
