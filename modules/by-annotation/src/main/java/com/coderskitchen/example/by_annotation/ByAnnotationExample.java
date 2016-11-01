package com.coderskitchen.example.by_annotation;

import com.coderskitchen.example.ValuePrinter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "module2")
@Setter
public class ByAnnotationExample implements ValuePrinter {
  private String myValue;

  public void printValue() {
    System.out.println(myValue);
  }
}
