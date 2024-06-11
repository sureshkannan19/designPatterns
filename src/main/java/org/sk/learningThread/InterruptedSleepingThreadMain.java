package org.sk.learningThread;

public class InterruptedSleepingThreadMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptedSleepingRunner());
        thread.start();
        // Giving 10 seconds to finish the job.
        Thread.sleep(5000);
        // Let me interrupt
        thread.interrupt();
    }
}