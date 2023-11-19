package be.atelierrafaelaferreira.gendointegration.model.entity;

import be.atelierrafaelaferreira.gendointegration.model.entity.types.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Cliente {
    private String id;
    private String idUser;
    private String nome;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    private String profissao;
    private String cpf;
    private Genero sexo;
    private String descricao;
    private String email;
    private Double saldo;
    private Double faturado;
    private Integer visitas;
    private String ultimaVisita;
    private Integer faltas;
    private String published;
    private String bloqueioAgenda;
    private String foto;

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", id_user='" + idUser + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                ", data_nascimento=" + dataNascimento +
                ", profissao='" + profissao + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo='" + sexo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", email='" + email + '\'' +
                ", saldo=" + saldo +
                ", faturado=" + faturado +
                ", visitas=" + visitas +
                ", ultima_visita='" + ultimaVisita + '\'' +
                ", faltas=" + faltas +
                ", published='" + published + '\'' +
                ", bloqueio_agenda='" + bloqueioAgenda + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
}
