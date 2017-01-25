package com.coderskitchen.example.by_application_listener_with_spring_factories;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;

public class PropertyFilePatternRegisteringListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

  public static final String PROPERTY_FILE_PREFIX = "application-module4";
  private static final String FILE_SUFFIX = ".properties";

  @Override
  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
    ConfigurableEnvironment environment = event.getEnvironment();
    try {
      loadProfileProperties(environment);
      loadPlainProperties(environment);
    } catch (IOException ex) {
      throw new IllegalStateException("Unable to load configuration files", ex);
    }
  }

  private void loadProfileProperties(ConfigurableEnvironment environment) throws IOException {
    String[] activeProfiles = environment.getActiveProfiles();
    if(activeProfiles != null && activeProfiles.length > 0)
      loadProfileProperties(environment, activeProfiles);
    else
      loadProfileProperties(environment, environment.getDefaultProfiles());
  }

  private void loadProfileProperties(ConfigurableEnvironment environment, String[] profiles) throws IOException {
    for (String activeProfile : profiles) {
      addFileToEnvironment(environment, PROPERTY_FILE_PREFIX + "-" + activeProfile + FILE_SUFFIX);
    }
  }

  private void loadPlainProperties(ConfigurableEnvironment environment) throws IOException {
    addFileToEnvironment(environment, PROPERTY_FILE_PREFIX + FILE_SUFFIX);
  }

  private void addFileToEnvironment(ConfigurableEnvironment environment, String file) throws IOException {
    ClassPathResource classPathResource = new ClassPathResource(file);
    if (classPathResource.exists()) {
      environment.getPropertySources()
                 .addLast(new ResourcePropertySource(classPathResource));
    }
  }
}
