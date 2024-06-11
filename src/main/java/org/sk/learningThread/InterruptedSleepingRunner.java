package org.sk.learningThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j( topic = "InterruptedSleepingRunner")
public class InterruptedSleepingRunner implements Runnable {
    @Override
    public void run() {
        doAPseudoHeavyWeightJob();
    }

    private void doAPseudoHeavyWeightJob() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            log.info(i + " " + i * 2);
            if (Thread.currentThread().isInterrupted()) {
                log.info("Thread interrupted\n Exiting...");
                break;
            } else {
                sleepBabySleep();
            }
        }
    }

    protected void sleepBabySleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.info("Interrupted");
            Thread.currentThread().interrupt();
        }
    }
}