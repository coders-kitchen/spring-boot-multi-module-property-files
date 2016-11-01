package com.coderskitchen.example.by_annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class ByAnnotationConfiguration {
  @Configuration
  @PropertySource(value = "classpath:application-module2.properties")
  static class DefaultProfile {

  }

  @Configuration
  @Profile("dev")
  @PropertySource(value = "classpath:application-module2-dev.properties")
  static class DevProfile {

  }
}
