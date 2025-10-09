package com.cardapio.backend.service;

import com.cardapio.backend.model.Pedido;
import com.cardapio.backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarTodosOsPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPedidoPorId(UUID id) {
        return pedidoRepository.findById(id);
    }

    public void deletarPedido(UUID id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido atualizarPedido(UUID id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(pedidoExistente -> {
                    pedidoExistente.setNomeCliente(pedidoAtualizado.getNomeCliente());
                    pedidoExistente.setTelefoneCliente(pedidoAtualizado.getTelefoneCliente());
                    return pedidoRepository.save(pedidoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));
    }
}