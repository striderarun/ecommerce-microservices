package com.eshop.product.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = {"com.eshop.product","com.eshop.common.config"})
@EntityScan(basePackages = "com.eshop.product.domain")
@EnableJpaRepositories(basePackages = "com.eshop.product.repository")
@EnableTransactionManagement
@EnableSpringConfigured
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
public class ProductConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProductConfig.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductConfig.class, args);
    }
}
