package com.snayder.kafkaproducer.pedido;

import java.io.Serializable;

public record PedidoDto(String nome, String usuario, String endereco) implements Serializable {
}
