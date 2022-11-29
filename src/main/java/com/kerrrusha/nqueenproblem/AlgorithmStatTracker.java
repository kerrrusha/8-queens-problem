package com.kerrrusha.nqueenproblem;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class AlgorithmStatTracker {

    private int steps;
    private final Stopwatch stopwatch;

    public AlgorithmStatTracker() {
        steps = 0;
        stopwatch = Stopwatch.createUnstarted();
    }

    public void start() {
        steps = 0;
        stopwatch.reset();
        stopwatch.start();
    }

    protected void addStep() {
        steps += 1;
    }

    public void stop() {
        stopwatch.stop();
    }

    public int getSteps() {
        return steps;
    }

    public long getTimeElapsedMillis() {
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }
}
