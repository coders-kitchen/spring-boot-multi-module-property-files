package com.coderskitchen.example;

import com.coderskitchen.example.by_application_listener.ByApplicationListenerExample;
import com.coderskitchen.example.by_application_listener.PropertyFilePatternRegisteringListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder().listeners(new PropertyFilePatternRegisteringListener())
                                                                           .sources(Application.class)
                                                                           .registerShutdownHook(true)
                                                                           .build()
                                                                           .run(args);
    context.getBean(ByApplicationListenerExample.class)
           .printValue();
  }
}
