package org.sk.learningThread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemoTest {
    private static final AtomicInteger x = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DeadLockDemo() ,"T1");
        Thread t2 = new Thread(new DeadLockDemo(),"T2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(x.get());
    }
    static class DeadLockDemo implements  Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1_00_000; i++) {
                x.incrementAndGet();
            }
        }
    }
}
