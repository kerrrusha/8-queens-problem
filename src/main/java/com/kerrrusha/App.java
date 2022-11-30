package com.kerrrusha;

import com.kerrrusha.nqueenproblem.NQueenProblemSolver;
import com.kerrrusha.nqueenproblem.stat.statetree.StateTreeView;

public class App {

    public static void main(String[] args) {
        final NQueenProblemSolver solver = new NQueenProblemSolver();

        solver.getTracker().start();
        solver.solveNQueen(0);
        solver.getTracker().stop();

        System.out.println(solver.getBoard());
        System.out.println(solver.getTracker());
        new StateTreeView<>(solver.getStateTree()).display();
    }
}
