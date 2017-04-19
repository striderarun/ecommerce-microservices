package com.eshop.discovery.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by arun_subramonian on 12/24/16.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryConfig {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryConfig.class, args);
    }
}
