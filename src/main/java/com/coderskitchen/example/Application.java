package com.coderskitchen.example;

import com.coderskitchen.example.by_application_listener.PropertyFilePatternRegisteringListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    new SpringApplicationBuilder()
        .listeners(new PropertyFilePatternRegisteringListener())
        .main(Application.class)
        .registerShutdownHook(true)
        .run(args);
  }
}
