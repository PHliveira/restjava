package com.cardapio.backend.service;


import com.cardapio.backend.model.Prato;
import com.cardapio.backend.repository.PratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Esta anotação marca a classe como um serviço do Spring
public class CardapioService {

    private final PratoRepository pratoRepository;

    // Injeção de dependência por construtor
    public CardapioService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    // Método que o seu teste espera
    public List<Prato> listarPratosDisponiveis() {
        // Lógica de negócio: chama o método do repositório
        return pratoRepository.findAll();
    }
}