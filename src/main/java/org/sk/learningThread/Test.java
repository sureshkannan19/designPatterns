package org.sk.learningThread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private static final Logger log = LoggerFactory.getLogger(Test.class.getSimpleName());

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        CompletableFuture<Void> f = CompletableFuture.runAsync(() -> {
                            try {
                                log.info("Inside Child Thread: {}", Thread.currentThread().getName());
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        , executorService)
                .exceptionally(ex -> {
                    throw new RuntimeException("");
                });

        f.thenRun(() -> {
            if (!executorService.isTerminated()) {
                log.info("Child thread closed properly: {}", Thread.currentThread().getName());
                executorService.shutdown();
            }
        });
        log.info("Main thread : {}", Thread.currentThread().getName());
//        System.exit(0);

    }
}