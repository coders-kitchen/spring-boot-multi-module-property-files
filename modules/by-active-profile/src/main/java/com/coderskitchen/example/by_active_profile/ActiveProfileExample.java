package com.coderskitchen.example.by_active_profile;

import com.coderskitchen.example.ValuePrinter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "module1")
@Setter
public class ActiveProfileExample implements ValuePrinter {
  private String myValue;

  public void printValue() {
    System.out.println(myValue);
  }
}
