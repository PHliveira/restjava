package com.cardapio.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nomeCliente;
    private String telefoneCliente;
    private String statusPedido;
    private LocalDateTime dataHoraPedido;
    private BigDecimal valorTotal;

    // Construtor vazio para JPA
    public Pedido() {}

    // Construtor completo para testes e serviços
    public Pedido(UUID id, String nomeCliente, String telefoneCliente,
                  String statusPedido, LocalDateTime dataHoraPedido, BigDecimal valorTotal) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.statusPedido = statusPedido;
        this.dataHoraPedido = dataHoraPedido;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getTelefoneCliente() { return telefoneCliente; }
    public void setTelefoneCliente(String telefoneCliente) { this.telefoneCliente = telefoneCliente; }

    public String getStatusPedido() { return statusPedido; }
    public void setStatusPedido(String statusPedido) { this.statusPedido = statusPedido; }

    public LocalDateTime getDataHoraPedido() { return dataHoraPedido; }
    public void setDataHoraPedido(LocalDateTime dataHoraPedido) { this.dataHoraPedido = dataHoraPedido; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
}