package be.atelierrafaelaferreira.gendointegration.model.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class Comanda {
    private Integer id;
    private LocalDate data;
    private Integer idPaciente;
    private Double total;
    private Double saldo;
    private Integer status;
    private Integer idCaixa;
    private Double desconto;
    private Integer prePago;
    private String dataLiberacao;
    private Integer liberada;
    private Double taxaCartao;
    private Double taxas;
    private Integer codigo;
    private String observacoes;
    private String notaFiscal;
    private String pacienteNome;
    private String telefone;
    private String servicos;
    private Map<Integer, PagamentoDetalhe> pagamentoDetalhes;

}
