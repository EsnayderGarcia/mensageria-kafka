package com.snayder.kafkaproducer.pedido;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.snayder.kafkaproducer.producer.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/pedidos")
public class PedidoRecurso {
    private final ProducerService producerService;

    public PedidoRecurso(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<String> gera(@RequestBody PedidoDto pedido) throws JsonProcessingException {
        producerService.envia(pedido);
        return ResponseEntity.ok("Pedido enviado");
    }
}
