package com.coderskitchen.example;

import com.coderskitchen.example.by_application_listener.PropertyFilePatternRegisteringListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

  @Autowired
  private List<ValuePrinter> valuePrinters;

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder().listeners(new PropertyFilePatternRegisteringListener())
                                                                           .sources(Application.class)
                                                                           .registerShutdownHook(true)
                                                                           .build()
                                                                           .run(args);
    context.getBean(Application.class)
           .executePrinters();
  }

  public void executePrinters() {
    for (ValuePrinter valuePrinter : valuePrinters) {
      valuePrinter.printValue();
    }
  }
}
