package be.atelierrafaelaferreira.gendointegration.model.entity;

import be.atelierrafaelaferreira.gendointegration.model.entity.types.StatusAgendamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Agendamento {
    private Integer id;
    private Integer idPaciente;
    private Integer idResponsavel;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Integer idPagamento;
    @JsonProperty("valor_toral")
    private Double valorTotal;
    private StatusAgendamento status;
    private Integer statusPagamento;
    private Integer idServico;
    private String comentario;
    private String uid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataAtualizacao;
    private Integer sequencia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriacao;
    private Integer lembrete;
    private Integer lembrado;
    private Integer idObject;
    private String canalOrigem;
    private String categoria;
    private String nomePaciente;
    private String telefone;
    private String email;
    private String nomeResponsavel;
    private String nomeServico;
    private String subcadastroDescricao;
    private String servicosAdicionais;

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", idPaciente=" + idPaciente +
                ", idResponsavel=" + idResponsavel +
                ", data=" + data +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                ", idPagamento=" + idPagamento +
                ", valorTotal=" + valorTotal +
                ", status=" + status +
                ", statusPagamento=" + statusPagamento +
                ", idServico=" + idServico +
                ", comentario='" + comentario + '\'' +
                ", uid='" + uid + '\'' +
                ", dataAtualizacao=" + dataAtualizacao +
                ", sequencia=" + sequencia +
                ", dataCriacao=" + dataCriacao +
                ", lembrete=" + lembrete +
                ", lembrado=" + lembrado +
                ", idObject=" + idObject +
                ", canalOrigem='" + canalOrigem + '\'' +
                ", categoria='" + categoria + '\'' +
                ", nomePaciente='" + nomePaciente + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                ", nomeServico='" + nomeServico + '\'' +
                ", subcadastroDescricao='" + subcadastroDescricao + '\'' +
                ", servicosAdicionais='" + servicosAdicionais + '\'' +
                '}';
    }
}
