package com.snayder.kafkaproducer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snayder.kafkaproducer.pedido.PedidoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Value("${topic.pedido-kafka}")
    private String topic;

    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void envia(PedidoDto pedidoDto) throws JsonProcessingException {
        String mensagem = objectMapper.writeValueAsString(pedidoDto);
        kafkaTemplate.send(topic, mensagem);
    }
}
