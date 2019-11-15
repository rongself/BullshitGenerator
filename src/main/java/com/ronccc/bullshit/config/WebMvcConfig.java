package com.ronccc.bullshit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronccc.bullshit.models.BullshitWord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class WebMvcConfig {
    @Value("classpath:data.json")
    private Resource data;

    @Bean(name="bullshitWord")
    public BullshitWord bullshitWord() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(data.getInputStream(), BullshitWord.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
