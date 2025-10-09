
package com.cardapio.backend.service;

import com.cardapio.backend.model.Prato;
import com.cardapio.backend.repository.PratoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardapioServiceTest {

    @Mock
    PratoRepository pratoRepository;

    @InjectMocks
    CardapioService cardapioService;

    @Test
    void should_return_all_available_pratos() {
        // Criando pratos usando construtor vazio + setters
        Prato prato1 = new Prato();
        prato1.setId(1L); // ou outro id fictício
        prato1.setNome("Hamburguer");
        prato1.setPreco(new BigDecimal("25.00"));

        Prato prato2 = new Prato();
        prato2.setId(2L);
        prato2.setNome("Batata Frita");
        prato2.setPreco(new BigDecimal("15.00"));

        // Mock do repositório
        when(pratoRepository.findAll()).thenReturn(Arrays.asList(prato1, prato2));

        // Chamando o serviço
        List<Prato> pratos = cardapioService.listarPratosDisponiveis();

        // Verificação
        assertThat(pratos).hasSize(2);
        assertThat(pratos).contains(prato1, prato2);
    }
}