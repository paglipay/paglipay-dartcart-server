package com.example.server.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.server")
@EntityScan("com.example.server.models")
@EnableJpaRepositories("com.example.server.repositories")
public class DartCartApplication {
  public static ApplicationContext app;

  public static void main(String[] args) {
    app = SpringApplication.run(DartCartApplication.class, args);
  }
}
