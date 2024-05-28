package org.sk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;

@Slf4j
@EnableAsync
@Configuration
public class AsyncConfig {
    @Bean
    public Executor taskExecutor() {
        var coreCount = Runtime.getRuntime().availableProcessors();
        return new TaskExecutorBuilder()
                .corePoolSize(coreCount)
                .maxPoolSize(coreCount)
                .threadNamePrefix("SK-")
                .build();
    }
}