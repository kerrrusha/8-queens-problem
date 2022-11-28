package com.kerrrusha;

import com.kerrrusha.nqueenproblem.NQueenProblemSolver;

public class App {

    public static void main(String[] args) {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        solver.solveNQueen(0);

        System.out.println(solver.getBoard());
    }
}
