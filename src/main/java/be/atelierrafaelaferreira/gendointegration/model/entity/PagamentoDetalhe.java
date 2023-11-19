package be.atelierrafaelaferreira.gendointegration.model.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PagamentoDetalhe {
    private LocalDate data;
    private LocalDate vencimento;
    private Double valor;
    private String descricao;
}
