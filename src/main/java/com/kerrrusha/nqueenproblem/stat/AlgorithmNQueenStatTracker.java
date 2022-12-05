package com.kerrrusha.nqueenproblem.stat;

public class AlgorithmNQueenStatTracker extends AlgorithmStatTracker {

    private int backtracksCount = 0;

    public AlgorithmNQueenStatTracker() {}

    public AlgorithmNQueenStatTracker(AlgorithmNQueenStatTracker other) {
        this.backtracksCount = other.backtracksCount;
        this.steps = other.steps;
        this.timeElapsedMillis = other.timeElapsedMillis;
        this.stopwatch = other.stopwatch;
    }

    @Override
    protected void reset() {
        backtracksCount = 0;
        super.reset();
    }

    public void addBacktrack() {
        backtracksCount += 1;
    }

    public int getBacktracksCount() {
        return backtracksCount;
    }

    @Override
    public String toString() {
        return getSteps() + " steps" + System.lineSeparator() +
                getBacktracksCount() + " backtracks" + System.lineSeparator() +
                getTimeElapsedMillis() + " ms" + System.lineSeparator();
    }
}
