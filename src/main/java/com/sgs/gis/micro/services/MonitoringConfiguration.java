package com.sgs.gis.micro.services;

import io.micrometer.core.aop.TimedAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MonitoringConfiguration {

  private static final Logger LOGGER = LoggerFactory.getLogger(MonitoringConfiguration.class);

  @Autowired
  Environment env;

  @Bean
  MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
    if (env.containsProperty("spring.application.name")) {
      return registry -> registry.config().commonTags("microservice_id", env.getProperty("spring.application.name"),
          "profile", StringUtils.arrayToCommaDelimitedString(env.getActiveProfiles()));
    } else {
      final String finalSpringApplicationName = "config-server";
      LOGGER.warn("'spring.application.name' environment variable is not set, setting programatically to : {} ",
          finalSpringApplicationName);
      return registry -> registry.config().commonTags("microservice_id", finalSpringApplicationName, "profile",
          StringUtils.arrayToCommaDelimitedString(env.getActiveProfiles()));
    }


  }
}
