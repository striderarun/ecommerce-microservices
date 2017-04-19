package com.eshop.shipping.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = {"com.eshop.shipping","com.eshop.common.config"})
@EntityScan(basePackages = "com.eshop.shipping.domain")
@EnableJpaRepositories(basePackages = "com.eshop.shipping.repository")
@EnableTransactionManagement
@EnableSpringConfigured
@EnableAutoConfiguration
@EnableKafka
@EnableEurekaClient
@SpringBootApplication
public class ShippingConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShippingConfig.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ShippingConfig.class, args);
    }
}
