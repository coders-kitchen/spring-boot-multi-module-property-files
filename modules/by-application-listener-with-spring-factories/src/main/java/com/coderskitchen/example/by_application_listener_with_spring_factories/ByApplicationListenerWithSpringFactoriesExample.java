package com.coderskitchen.example.by_application_listener_with_spring_factories;

import com.coderskitchen.example.ValuePrinter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "module4")
@Setter
public class ByApplicationListenerWithSpringFactoriesExample implements ValuePrinter {
  private String myValue;

  public void printValue() {
    System.out.println(myValue);
  }
}
