package com.snayder.kafkaconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snayder.kafkaconsumer.pedido.PedidoDto;
import com.snayder.kafkaconsumer.pedido.PedidoServico;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumidorServico {
    private final PedidoServico pedidoServico;
    private final ObjectMapper objectMapper;

    public ConsumidorServico(PedidoServico pedidoServico, ObjectMapper objectMapper) {
        this.pedidoServico = pedidoServico;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${topic.pedido-kafka}", groupId = "group_id")
    public void ouvinte(String mensagem) throws JsonProcessingException {
        PedidoDto pedidoDto = objectMapper.readValue(mensagem, PedidoDto.class);
        pedidoServico.salva(pedidoDto);
    }
}
