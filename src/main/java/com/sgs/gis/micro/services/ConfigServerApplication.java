package com.sgs.gis.micro.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Import;

@EnableConfigServer
@SpringBootApplication
@Import({ MonitoringConfiguration.class })
public class ConfigServerApplication {

  protected ConfigServerApplication() {
    super();
  }

  public static void main(String[] args) {
    SpringApplication.run(ConfigServerApplication.class, args);
  }

}
