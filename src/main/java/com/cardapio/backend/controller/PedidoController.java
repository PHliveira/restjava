package com.cardapio.backend.controller;

import com.cardapio.backend.model.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.cardapio.backend.service.PedidoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    // Construtor para injeção de dependência do serviço
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido novoPedido) {
        Pedido pedidoSalvo = pedidoService.criarPedido(novoPedido);
        return new ResponseEntity<>(pedidoSalvo, HttpStatus.CREATED);
    }
        // Endpoint 1
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarTodosOsPedidos();
    }
     //Endpoint 2 buscar pelo ID
     @GetMapping("/{id}")
     public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable UUID id) {
         Optional<Pedido> pedidoOptional = pedidoService.buscarPedidoPorId(id);

         return pedidoOptional.map(pedido -> ResponseEntity.ok().body(pedido))
                 .orElse(ResponseEntity.notFound().build());
     }

     // Endpoint deletar
     @DeleteMapping("/{id}")
     @ResponseStatus(HttpStatus.NO_CONTENT)
     public void deletarPedido(@PathVariable UUID id) {
         pedidoService.deletarPedido(id);
     }

     // Endpoint atualziar
     @PutMapping("/{id}")
     public ResponseEntity<Pedido> atualizarPedido(
             @PathVariable UUID id,
             @RequestBody Pedido pedidoAtualizado
     ) {
         try {
             Pedido pedido = pedidoService.atualizarPedido(id, pedidoAtualizado);
             return ResponseEntity.ok().body(pedido);
         } catch (RuntimeException ex) {
             return ResponseEntity.notFound().build();
         }
     }
}