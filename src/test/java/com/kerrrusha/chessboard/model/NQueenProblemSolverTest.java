package com.kerrrusha.chessboard.model;

import com.kerrrusha.chessboard.analyzer.ChessBoardAnalyzer;
import com.kerrrusha.nqueenproblem.NQueenProblemSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NQueenProblemSolverTest {

    @Test
    public void solveNQueenSolvedTest() {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        final boolean solved = solver.solveNQueen(0);

        System.out.println(solver.getBoard());
        assertTrue(solved);
    }

    @Test
    public void solveNQueenNoUnderAttackTest() {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        solver.solveNQueen(0);

        System.out.println(solver.getBoard());
        assertTrue(new ChessBoardAnalyzer(solver.getBoard()).getChessPiecesUnderAttack().isEmpty());
    }
}
