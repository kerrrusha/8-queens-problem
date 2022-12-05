package com.kerrrusha;

import com.kerrrusha.nqueenproblem.NQueenProblemSolver;
import com.kerrrusha.nqueenproblem.stat.statetree.algorithm.BFSAlgorithm;
import com.kerrrusha.stat.TaskResult;
import com.kerrrusha.stat.TaskStatTracker;
import com.kerrrusha.timeobserver.TimeObserver;
import com.kerrrusha.util.FileUtil;
import org.apache.log4j.Logger;

public class App {

    private static final int[][] initStates = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {2, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 0, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 2},
            {3, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 0, 0, 0}
    };

    private static final Logger logger = Logger.getLogger(App.class);

    private final TaskStatTracker taskStatTracker;
    private TimeObserver timeObserver;

    public static void main(String[] args) {
        new App(args).run();
    }

    public App(String[] args) {
        taskStatTracker = new TaskStatTracker();
        processArgs(args);
    }

    private void processArgs(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        long secondsToLive;

        try {
            secondsToLive = Long.parseLong(args[0]);
        } catch (Throwable e) {
            logger.error(e);
            return;
        }

        timeObserver = new TimeObserver(secondsToLive);
    }

    public void run() {
        logger.info("Task was started.");
        ifPresentStartTimeObserver();
        for (int[] initState : initStates) {
            doTask(initState);
        }
        logger.info(taskStatTracker.getAvgTimeStatMessage());
        logger.info(taskStatTracker.getAvgStateGeneratedMessage());
        logger.info(taskStatTracker.getAvgInMemoryStatesMessage());

        exportCsv();
        logger.info("CSV data was exported successfully.");
    }

    private void ifPresentStartTimeObserver() {
        if (timeObserver == null) {
            return;
        }
        timeObserver.startCountdown();
    }

    private void exportCsv() {
        FileUtil.writeToFile("task-results.csv", taskStatTracker.getExportableCsvData());
    }

    private void doTask(int[] initState) {
        final NQueenProblemSolver solver = new NQueenProblemSolver();
        final TaskResult result = new TaskResult();

        solver.setInitState(initState);
        result.setInitState(initState);

        solver.getTracker().start();
        solver.doRBFSAlgorithm(0);
        solver.getTracker().stop();

        result.setRbfsStat(solver.getTrackerCopy());

        solver.getTracker().start();
        new BFSAlgorithm<>(solver.getStateTree()).doBFS();
        solver.getTracker().stop();

        result.setBfsStat(solver.getTrackerCopy());
        result.setSolvedState(solver.getSolvedState());

        taskStatTracker.add(result);
    }
}
