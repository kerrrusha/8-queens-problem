package com.kerrrusha.nqueenproblem.stat;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class AlgorithmStatTracker {

    protected int steps = 0;
    protected long timeElapsedMillis = 0;
    protected Stopwatch stopwatch;

    public AlgorithmStatTracker() {
        stopwatch = Stopwatch.createUnstarted();
    }

    public void start() {
        reset();
        stopwatch.start();
    }

    protected void reset() {
        steps = 0;
        timeElapsedMillis = 0;
        stopwatch.reset();
    }

    public void addStep() {
        steps += 1;
    }

    public void stop() {
        stopwatch.stop();
        timeElapsedMillis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    public int getSteps() {
        return steps;
    }

    public long getTimeElapsedMillis() {
        return timeElapsedMillis;
    }

    @Override
    public String toString() {
        return getSteps() + " nodes was created" + System.lineSeparator() +
                getTimeElapsedMillis() + " ms" + System.lineSeparator();
    }
}
