package com.eshop.common.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by arun_subramonian on 12/21/16.
 */
@Configuration
public class CommonConfig {

    @Bean
    public Mapper mapper() {
        Mapper mapper = new DozerBeanMapper();
        return mapper;
    }
}
