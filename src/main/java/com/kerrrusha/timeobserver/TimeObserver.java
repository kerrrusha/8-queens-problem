package com.kerrrusha.timeobserver;

import org.apache.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class TimeObserver {

    private static final Logger logger = Logger.getLogger(TimeObserver.class);

    private final long secondsToLive;
    private Timer timer;
    private TimerTask task;

    public TimeObserver(long secondsToLive) {
        this.secondsToLive = secondsToLive;
        timer = new Timer("Timer-Killer");

        task = new TimerTask() {
            public void run() {
                exitProgram();
            }
        };
    }

    public void startCountdown() {
        timer.schedule(task, secondsToLive);
        logger.info("Started countdown for "+secondsToLive+" ms.");
    }

    public void exitProgram() {
        logger.info("Time count is down. Exiting program.");

        task.cancel();
        timer.cancel();
        timer.purge();
        timer = null;
        task = null;

        System.exit(0);
    }
}
