package com.snayder.kafkaconsumer.pedido;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/consumer/pedidos")
public class PedidoRecurso {
    private final PedidoServico pedidoServico;

    public PedidoRecurso(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> busca() {
        return ResponseEntity.ok(pedidoServico.busca());
    }
}
