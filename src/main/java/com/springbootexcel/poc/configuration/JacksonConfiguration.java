package com.springbootexcel.poc.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.springbootexcel.poc.model.NetflixTitlesEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper objectMapper(NetflixTitlesEntitySerializer netflixTitlesEntitySerializer) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(NetflixTitlesEntity.class, netflixTitlesEntitySerializer);
        mapper.registerModule(module);
        return mapper;
    }
}
