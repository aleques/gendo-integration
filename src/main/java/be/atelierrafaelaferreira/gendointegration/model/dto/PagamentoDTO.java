package be.atelierrafaelaferreira.gendointegration.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PagamentoDTO {
    private LocalDate data;
    private LocalDate vencimento;
    private Double valor;
    private String descricao;
}
