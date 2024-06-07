package org.sk.learningThread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Slf4j(topic = "VE")
public class VolatileExperiment {

    private VolatileExperiment() {

    }

    private static volatile VolatileExperiment instanceWithVolatile;
    private static VolatileExperiment instanceWithoutVolatile;

    private static VolatileExperiment getInstanceWithVolatile() {
        if (Objects.isNull(instanceWithVolatile)) {
            synchronized (VolatileExperiment.class) {
                if (instanceWithVolatile == null) {
                    instanceWithVolatile = new VolatileExperiment();
                }
            }
        }
        return instanceWithVolatile;
    }

    /*
    Potential Issues Without volatile
    Visibility Problem:
    A thread might read a stale value of instanceWithoutVolatile, i.e.,
    it might see the variable as null even after another thread has assigned it a new instance.
    Reordering Problem:
    The JVM might reorder instructions so that the reference to the new VolatileExperiment instance
    is set before the constructor has finished executing, leading to a partially constructed object being visible to other threads.
     */
    private static VolatileExperiment getInstanceWithoutVolatile() {
        if (Objects.isNull(instanceWithoutVolatile)) {
            synchronized (VolatileExperiment.class) {
                if (instanceWithoutVolatile == null) {
                    instanceWithoutVolatile = new VolatileExperiment();
                }
            }
        }
        return instanceWithoutVolatile;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(  5);
        List<CompletableFuture<Void>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(CompletableFuture.runAsync(() -> {
                VolatileExperiment ve = VolatileExperiment.getInstanceWithVolatile();
                log.info("Thread name {} - Volatile  instance {} ", Thread.currentThread().getName(), ve);
            }, es));
        } CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()])).join();

        List<CompletableFuture<Void>> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(CompletableFuture.runAsync(() -> {
                VolatileExperiment ve = VolatileExperiment.getInstanceWithoutVolatile();
                log.info("Thread name {} - Non-Volatile instance {} ", Thread.currentThread().getName(), ve);
            }, es));
        } CompletableFuture.allOf(list1.toArray(new CompletableFuture[list1.size()])).join();

        if (!es.isTerminated()) {
            es.shutdown();
        }
    }
}
