package com.snayder.kafkaconsumer.pedido;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoServico {
    private final PedidoRepositorio pedidoRepositorio;

    public PedidoServico(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Transactional
    public void salva(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido(pedidoDto.nome(), pedidoDto.usuario(), pedidoDto.endereco());
        pedidoRepositorio.save(pedido);
    }
}
