package com.kerrrusha;

import com.kerrrusha.nqueenproblem.NQueenProblemSolver;

public class App {

    public static void main(String[] args) {
        doTask(new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        doTask(new int[]{1, 0, 0, 0, 0, 0, 0, 0});
        doTask(new int[]{0, 1, 0, 0, 0, 0, 0, 0});
        doTask(new int[]{0, 0, 1, 0, 0, 0, 0, 0});
        doTask(new int[]{0, 0, 0, 1, 0, 0, 0, 0});
        doTask(new int[]{0, 0, 0, 0, 1, 0, 0, 0});
        doTask(new int[]{0, 0, 0, 0, 0, 1, 0, 0});
        doTask(new int[]{0, 0, 0, 0, 0, 0, 1, 0});
        doTask(new int[]{0, 0, 0, 0, 0, 0, 0, 1});
        doTask(new int[]{2, 0, 0, 0, 0, 0, 0, 0});
        doTask(new int[]{0, 2, 0, 0, 0, 0, 0, 0});
        doTask(new int[]{0, 0, 2, 0, 0, 0, 0, 0});
        doTask(new int[]{0, 0, 0, 2, 0, 0, 0, 0});
        doTask(new int[]{0, 0, 0, 0, 2, 0, 0, 0});
        doTask(new int[]{0, 0, 0, 0, 0, 2, 0, 0});
        doTask(new int[]{0, 0, 0, 0, 0, 0, 2, 0});
        doTask(new int[]{0, 0, 0, 0, 0, 0, 0, 2});
        doTask(new int[]{3, 0, 0, 0, 0, 0, 0, 0});
        doTask(new int[]{0, 3, 0, 0, 0, 0, 0, 0});
        doTask(new int[]{0, 0, 3, 0, 0, 0, 0, 0});
    }

    public static void doTask(int[] colsStartRowValues) {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        solver.setColsStartRowValues(colsStartRowValues);

        solver.getTracker().start();
        solver.solveNQueen(0);
        solver.getTracker().stop();

        System.out.println(solver.getBoard());
        System.out.println(solver.getTracker());
    }
}
