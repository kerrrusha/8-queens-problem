package com.kerrrusha.chessboard.model;

import com.kerrrusha.nqueenproblem.AlgorithmStatTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlgorithmStatTrackerTest {

    @Test
    public void getTimeElapsedMillisTest() throws InterruptedException {
        final AlgorithmStatTracker stat = new AlgorithmStatTracker();
        final int expectedMillis = 1000;

        stat.start();
        Thread.sleep(expectedMillis);
        stat.stop();

        final long elapsed = stat.getTimeElapsedMillis();
        final double accuracyMillis = expectedMillis * 0.1;
        assertTrue(expectedMillis - accuracyMillis <= elapsed &&
                elapsed <= expectedMillis + accuracyMillis);
    }
}
