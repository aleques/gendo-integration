package be.atelierrafaelaferreira.gendointegration.model.dto;

import be.atelierrafaelaferreira.gendointegration.model.dto.types.DTOType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Builder
public class ClienteDTO implements CsvBaseDTO {

    private String idCliente;
    private String nome;
    private String sobrenome;
    private String nomeCompleto;
    private Integer agendamentos;
    private Integer ausencias;
    private String genero;
    private String numeroDeCelular;
    private String eMail;
    private LocalDate dataDeNascimento;
    private String observacao;

    public static String getCsvHeader() {
        return "ID do cliente" +
         ",Nome" +
         ",Sobrenome" +
         ",Nome completo" +
         //",Bloqueado" +
         //",Motivo do bloqueio" +
         ",Agendamentos" +
         ",Ausências" +
         //",Total de vendas" +
         //",Pendente" +
         ",Gênero" +
         ",Número de celular" +
         //",Telefone" +
         ",E-mail" +
         //",Aceita marketing" +
         //",Aceita SMS de marketing" +
         //",Endereço" +
         //",Número do apartamento" +
         //",Área" +
         //",Cidade" +
         //",Estado" +
         //",Código postal" +
         ",Data de nascimento" +
         //",Adicionado" +
         ",Observação";
         //",Fonte de indicação";
    }

    @Override
    public String toCsv() {
        return  Objects.toString(getIdCliente(), "") +
                "," + Objects.toString(getNome(), "") +
                "," + Objects.toString(getSobrenome(), "") +
                "," + Objects.toString(getNomeCompleto(), "") +
                "," + Objects.toString(getAgendamentos(), "") +
                "," + Objects.toString(getAusencias(), "") +
                "," + Objects.toString(getGenero(), "") +
                "," + Objects.toString(getNumeroDeCelular(), "") +
                "," + Objects.toString(getEMail(), "") +
                "," + Objects.toString(getDataDeNascimento(), "") +
                "," + Objects.toString(getObservacao(), "").replace(",", ";");
    }

    @Override
    public DTOType getType() {
        return DTOType.CLIENTE;
    }
}
