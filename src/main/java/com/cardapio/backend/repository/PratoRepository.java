package com.cardapio.backend.repository;


import com.cardapio.backend.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository; // <-- Importe esta classe
import org.springframework.stereotype.Repository;

import java.util.UUID; // <-- Importe o UUID


//  INTERFACE É A PONTE ENTRE MODEL E SERVICE

// A sua interface agora herda de JpaRepository
@Repository
public interface PratoRepository extends JpaRepository<Prato, UUID> {
}