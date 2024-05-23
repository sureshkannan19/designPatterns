package org.sk.learningThread;

public class DeadLockDemoTest {

    public static void main(String[] args) {
        final Object obj1 = new Object();
        final Object obj2 = new Object();
        Thread t1 = new Thread(new DeadLockDemo(obj1, obj2) ,"T1");
        Thread t2 = new Thread(new DeadLockDemo(obj2, obj1),"T2");
        t1.start();
        t2.start();
        // To avoid deadlock, thread locking should happen in same order for all threads
    }

    static class DeadLockDemo implements  Runnable {
        final Object obj1;
        final Object obj2;
        DeadLockDemo(Object obj1, Object obj2) {
            this.obj1 =obj1;
            this.obj2 =obj2;
        }
        @Override
        public void run() {
            synchronized (obj1) {
                System.out.println("Obj1 Lock Acquired by " + Thread.currentThread().getName());
                synchronized (obj2) {
                    System.out.println("Obj2 Lock Acquired by " + Thread.currentThread().getName());
                }
            }
        }
    }

}
