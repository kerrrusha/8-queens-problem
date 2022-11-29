package com.kerrrusha.nqueenproblem;

public class AlgorithmNQueenStatTracker extends AlgorithmStatTracker {

    private int backtracksCount = 0;

    @Override
    protected void reset() {
        backtracksCount = 0;
        super.reset();
    }

    protected void addBacktrack() {
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
