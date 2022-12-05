package com.kerrrusha.stat;

import com.kerrrusha.nqueenproblem.stat.AlgorithmNQueenStatTracker;

import static com.kerrrusha.util.MapUtil.mapArrayToString;

public class TaskResult {

    private int[] initState;
    private int[] solvedState;
    private AlgorithmNQueenStatTracker bfsStat;
    private AlgorithmNQueenStatTracker rbfsStat;

    public String getInitStateStr() {
        return mapArrayToString(initState);
    }

    public void setInitState(int[] initState) {
        this.initState = initState;
    }

    public String getSolvedStateStr() {
        return mapArrayToString(solvedState);
    }

    public void setSolvedState(int[] solvedState) {
        this.solvedState = solvedState;
    }

    public AlgorithmNQueenStatTracker getBfsStat() {
        return bfsStat;
    }

    public void setBfsStat(AlgorithmNQueenStatTracker bfsStat) {
        this.bfsStat = bfsStat;
    }

    public AlgorithmNQueenStatTracker getRbfsStat() {
        return rbfsStat;
    }

    public void setRbfsStat(AlgorithmNQueenStatTracker rbfsStat) {
        this.rbfsStat = rbfsStat;
    }
}
