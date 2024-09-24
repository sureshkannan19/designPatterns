package org.sk.learningThread;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class DataPassBetweenThreads {

    public static void main(String[] args) {

        UserHandler.set(new UserInfo("SK", "READER"));

        ExecutorService ex = Executors.newFixedThreadPool(3);

        List<CompletableFuture<Void>> allFutures = new ArrayList<>();

        allFutures.add(CompletableFuture.runAsync(() -> doSomething()));
        allFutures.add(CompletableFuture.runAsync(() -> doSomething()));
        allFutures.add(CompletableFuture.runAsync(() -> doSomething()));

        try {
            CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[allFutures.size()])).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            if (!ex.isTerminated()) {
                ex.shutdown();
            }
            UserHandler.remove();
        }

    }

    private static void doSomething() {
        log.info("Inside thread: {} and Logged in User: {} ", Thread.currentThread().getName(), UserHandler.get());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class UserHandler {

        private static final InheritableThreadLocal<UserInfo> handler = new InheritableThreadLocal<>();

        public static void set(UserInfo info) {
            handler.set(info);
        }

        public static UserInfo get() {
            return handler.get();
        }

        public static void remove() {
            handler.remove();
        }

    }

    @AllArgsConstructor
    @ToString
    public static class UserInfo {

        String userName;
        String eligibleRole;

    }

}
