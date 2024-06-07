package org.sk.learningThread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Component
@Slf4j
public class StreamTest {

    @Autowired
    private Executor taskExecutor;

    @Async
    public void testParallelThreadsViaExecutor() {
        CompletableFuture.runAsync(() -> {
            log.info(" Thread name {} " , Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            log.info(" Processed Thread name {} " , Thread.currentThread().getName());
        }, taskExecutor);
    }

}
