package com.cardapio.backend.service;

import com.cardapio.backend.model.Pedido;
import com.cardapio.backend.repository.PedidoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    @Test
    void should_create_a_new_pedido() {
        // 1. Cenário: Crie um pedido mock
        UUID pedidoId = UUID.randomUUID();
        Pedido pedido = new Pedido(); // usa construtor vazio
        pedido.setId(pedidoId);
        pedido.setNomeCliente("João da Silva");
        pedido.setTelefoneCliente("11999999999");
        pedido.setStatusPedido("PENDENTE");
        pedido.setDataHoraPedido(LocalDateTime.now());
        pedido.setValorTotal(BigDecimal.valueOf(45.50));

        // 2. Comportamento: Diga ao Mockito o que fazer
        Mockito.when(pedidoRepository.save(Mockito.any(Pedido.class))).thenReturn(pedido);

        // 3. Ação: Chame o método que você quer testar
        Pedido pedidoSalvo = pedidoService.criarPedido(pedido);

        // 4. Verificação: Verifique se o resultado é o que você espera
        Assertions.assertNotNull(pedidoSalvo);
        Assertions.assertEquals(pedidoId, pedidoSalvo.getId());
        Assertions.assertEquals("João da Silva", pedidoSalvo.getNomeCliente());

        // Verifique se o método 'save' foi chamado no repositório.
        Mockito.verify(pedidoRepository, Mockito.times(1)).save(Mockito.any(Pedido.class));
    }
}