package com.kafka.orderservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class KafkaConfiguration {

    @Value("${kafka.topics}")
    private String[] topics;


    @Bean
    public List<NewTopic> kafkaTopics() {
        List<NewTopic> newTopics = new ArrayList<>();
        System.out.println(Arrays.toString(topics));
        for (String topicName : topics) {
            newTopics.add(new NewTopic(topicName, 10, (short) 2));
        }
        return newTopics;
    }
}
