package com.coderskitchen.example.by_application_listener;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "module3")
@Setter
public class ByApplicationListenerExample {
  private String myValue;

  public void printValue() {
    System.out.println(myValue);
  }
}
