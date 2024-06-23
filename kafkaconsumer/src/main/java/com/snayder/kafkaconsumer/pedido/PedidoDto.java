package com.snayder.kafkaconsumer.pedido;

public record PedidoDto(
    Long id,
    String nome,
    String usuario,
    String endereco
) {
    public PedidoDto(Pedido pedido) {
        this(pedido.getId(), pedido.getNome(), pedido.getUsuario(), pedido.getEndereco());
    }
}
