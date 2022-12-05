package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.analyzer.ChessBoardAnalyzer;
import com.kerrrusha.nqueenproblem.NQueenProblemSolver;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class NQueenProblemSolverTest {

    @Test
    public void solveNQueenSolvedTest() {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        final boolean solved = solver.doRBFSAlgorithm(0);

        System.out.println(solver.getBoard());
        assertTrue(solved);
    }

    @Test
    public void solveNQueenNoUnderAttackTest() {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        solver.doRBFSAlgorithm(0);

        System.out.println(solver.getBoard());
        assertTrue(new ChessBoardAnalyzer(solver.getBoard()).getChessPiecesUnderAttack().isEmpty());
    }

    @Test
    public void getSolvedStateTest() {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        solver.doRBFSAlgorithm(0);

        System.out.println(solver.getBoard());
        System.out.println(Arrays.toString(solver.getSolvedState()));

        assertArrayEquals(new int[]{0, 6, 4, 7, 1, 3, 5, 2}, solver.getSolvedState());
    }
}
