package com.kerrrusha.stat;

import java.util.ArrayList;
import java.util.Collection;

public class TaskStatTracker {

    private final Collection<TaskResult> taskResults;

    public TaskStatTracker() {
        taskResults = new ArrayList<>();
    }

    public void add(TaskResult taskResult) {
        taskResults.add(taskResult);
    }

    public String getAvgInMemoryStatesMessage() {
        return "Avg in-memory states generated: " + getAvgInMemoryStates();
    }

    private double getAvgInMemoryStates() {
        return taskResults.stream()
                .map(t -> t.getRbfsStat().getSteps())
                .mapToDouble(x -> x)
                .average()
                .orElse(Double.NaN);
    }

    public String getAvgStateGeneratedMessage() {
        return "Avg states generated: " + getAvgStateGenerated();
    }

    private double getAvgStateGenerated() {
        return taskResults.stream()
                .map(t -> t.getRbfsStat().getBacktracksCount())
                .mapToDouble(x -> x)
                .average()
                .orElse(Double.NaN);
    }

    public String getAvgTimeStatMessage() {
        return "Avg BFS time: " + getAvgBFSTime() + " ms" + System.lineSeparator()
                + "Avg RBFS time: " + getAvgRBFSTime() + " ms";
    }

    private double getAvgBFSTime() {
        return taskResults.stream()
                .map(t -> t.getBfsStat().getTimeElapsedMillis())
                .mapToDouble(x -> x)
                .average()
                .orElse(Double.NaN);
    }

    private double getAvgRBFSTime() {
        return taskResults.stream()
                .map(t -> t.getRbfsStat().getTimeElapsedMillis())
                .mapToDouble(x -> x)
                .average()
                .orElse(Double.NaN);
    }

    public String getExportableCsvData() {
        final StringBuilder builder = new StringBuilder();

        builder.append(getCsvHeader()).append(System.lineSeparator());
        int counter = 1;
        for (TaskResult result : taskResults) {
            builder.append(mapResultToCsv(counter, result)).append(System.lineSeparator());
            counter++;
        }

        return builder.toString();
    }

    private String getCsvHeader() {
        return "#,initState,algorithm,solvedState,timeMs,generatedStates,inMemoryStates";
    }

    private String mapResultToCsv(int counter, TaskResult result) {
        final String SEPARATOR = ",";
        return counter + SEPARATOR + result.getInitStateStr() + SEPARATOR + "BFS" + SEPARATOR + result.getSolvedStateStr() + SEPARATOR +
                result.getBfsStat().getTimeElapsedMillis() + SEPARATOR + result.getRbfsStat().getBacktracksCount() + SEPARATOR +
                result.getRbfsStat().getSteps() + System.lineSeparator() +
                counter + SEPARATOR + result.getInitStateStr() + SEPARATOR + "RBFS" + SEPARATOR + result.getSolvedStateStr() + SEPARATOR +
                result.getRbfsStat().getTimeElapsedMillis() + SEPARATOR + result.getRbfsStat().getBacktracksCount() + SEPARATOR +
                result.getRbfsStat().getSteps() + System.lineSeparator();
    }
}
