package com.kerrrusha.nqueenproblem;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class AlgorithmStatTracker {

    private int steps = 0;
    private final Stopwatch stopwatch;

    public AlgorithmStatTracker() {
        stopwatch = Stopwatch.createUnstarted();
    }

    public void start() {
        reset();
        stopwatch.start();
    }

    protected void reset() {
        steps = 0;
        stopwatch.reset();
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

    @Override
    public String toString() {
        return getSteps() + " steps" + System.lineSeparator() +
                getTimeElapsedMillis() + " ms" + System.lineSeparator();
    }
}
