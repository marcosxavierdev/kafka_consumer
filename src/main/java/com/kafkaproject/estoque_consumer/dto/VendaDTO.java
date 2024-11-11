package com.kafkaproject.estoque_consumer.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class VendaDTO {
    private String idVenda;
    private String idProduto;
    private Integer quantidade;
    private Double valorTotal;
    private LocalDate dataVenda;
    private String tipo;

    public VendaDTO(String idVenda, String idProduto, Integer quantidade, Double valorTotal, LocalDate dataVenda, String tipo) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.tipo = tipo;
    }
}
