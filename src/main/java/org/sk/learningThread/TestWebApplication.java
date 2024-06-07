package org.sk.learningThread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestWebApplication.class, args);
        StreamTest st = context.getBean(StreamTest.class);
        for (int i = 0; i < 8; i++) {
            st.testParallelThreadsViaExecutor();
        }
    }

    public static void stop(ConfigurableApplicationContext configurableApplicationContext) {
        configurableApplicationContext.close();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.profiles("default");
        return builder.sources(TestWebApplication.class);
    }
}


