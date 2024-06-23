package org.sk.designpatterns.observer.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringObserverApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringObserverApplication.class, args);
        StockService service= context.getBean(StockService.class);
        service.updateStock();
        System.exit(0);
    }

    public static void stop(ConfigurableApplicationContext configurableApplicationContext) {
        configurableApplicationContext.close();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.profiles("default");
        return builder.sources(org.sk.learningThread.TestWebApplication.class);
    }
}
