package br.com.beautique.services.impl;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.beautique.configurations.RabbitMQTopicConfig;
import br.com.beautique.services.BrokerService;

@Service
public class RabbitMQServiceImpl implements BrokerService {

    private final ObjectMapper objectMapper;

    private final RabbitTemplate rabbitTemplate;

    private final RabbitMQTopicConfig rabbitMQTopicConfig;

    public RabbitMQServiceImpl(ObjectMapper objectMapper, RabbitTemplate rabbitTemplate, RabbitMQTopicConfig rabbitMQTopicConfig) {
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQTopicConfig = rabbitMQTopicConfig;
    }

    @Override
    public void send(String type, Object data) {
        String routingKey = type + ".#";
        try {
            String jsonMessage = objectMapper.writeValueAsString(data);
        
            rabbitTemplate.convertAndSend(rabbitMQTopicConfig.exchangeName, routingKey, jsonMessage, message -> {
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);;
                return message;
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
