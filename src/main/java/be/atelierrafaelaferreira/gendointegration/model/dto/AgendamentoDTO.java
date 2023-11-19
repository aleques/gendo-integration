package be.atelierrafaelaferreira.gendointegration.model.dto;

import be.atelierrafaelaferreira.gendointegration.model.dto.types.DTOType;
import be.atelierrafaelaferreira.gendointegration.model.entity.types.StatusAgendamento;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Data
@Builder
public class AgendamentoDTO implements CsvBaseDTO {
    private Integer id;
    private Integer idPaciente;
    private Integer idResponsavel;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Double valorTotal;
    private StatusAgendamento status;
    private Integer idServico;
    private String comentario;
    private String categoria;
    private String nomePaciente;
    private String telefone;
    private String email;
    private String nomeResponsavel;
    private String nomeServico;
    private String subcadastroDescricao;
    private String servicosAdicionais;
    private LocalDate dataUltimoAgendamento;
    private Integer dataAno;
    private String dataMes;
    private Integer dataSemana;
    private Integer dataDia;
    private Double valorTotal90;
    private Boolean saFibra;
    private Boolean saLash;
    private Integer indicePresenca;
    private String nomeDoNegocio;
    private String whatsAppAPP;
    private String whatsAppWEB;
    private String origemGendo;
    private String pipeline;

    public static String getCsvHeader() {
        return "Id" +
                ",IdPaciente" +
                ",IdResponsavel" +
                ",Data" +
                ",DataAno" +
                ",DataMes" +
                ",DataSemana" +
                ",DataDia" +
                ",HoraInicio" +
                ",HoraFim" +
                ",ValorTotal" +
                ",ValorTotal90" +
                ",Status" +
                ",StatusFiltro" +
                ",IdServico" +
                ",Comentario" +
                ",Categoria" +
                ",NomePaciente" +
                ",Telefone" +
                ",Email" +
                ",NomeResponsavel" +
                ",NomeServico" +
                ",SubcadastroDescricao" +
                ",ServicosAdicionais" +
                ",DataUltimoAgendamento" +
                ",SA-Fibra" +
                ",SA-Lash" +
                ",IndicePresenca" +
                ",NomeDoNegocio" +
                ",WhatsAppAPP" +
                ",WhatsAppWEB" +
                ",OrigemGendo" +
                ",Pipeline";

    }

    @Override
    public String toCsv() {

        return Objects.toString(getId(), "") +
                "," + Objects.toString(getIdPaciente(), "") +
                "," + Objects.toString(getIdResponsavel(), "") +
                "," + Objects.toString(getData(), "") +
                "," + Objects.toString(getDataAno(), "") +
                "," + Objects.toString(getDataMes(), "") +
                "," + Objects.toString(getDataSemana(), "") +
                "," + Objects.toString(getDataDia(), "") +
                "," + Objects.toString(getHoraInicio(), "") +
                "," + Objects.toString(getHoraFim(), "") +
                "," + Objects.toString(getValorTotal(), "") +
                "," + Objects.toString(getValorTotal90(), "") +
                "," + Objects.toString(getStatus(), "") +
                "," + Objects.toString(getStatus(), "") +
                "," + Objects.toString(getIdServico(), "") +
                "," + Objects.toString(getComentario(), "").replace(",", ";") +
                "," + Objects.toString(getCategoria(), "").replace(",", ";") +
                "," + Objects.toString(getNomePaciente(), "").replace(",", ";") +
                "," + Objects.toString(getTelefone(), "").replace(",", ";") +
                "," + Objects.toString(getEmail(), "").replace(",", ";") +
                "," + Objects.toString(getNomeResponsavel(), "").replace(",", ";") +
                "," + Objects.toString(getNomeServico(), "").replace(",", ";") +
                "," + Objects.toString(getSubcadastroDescricao(), "").replace(",", ";") +
                "," + Objects.toString(getServicosAdicionais(), "").replace(",", ";") +
                "," + Objects.toString(getDataUltimoAgendamento(), "") +
                "," + Objects.toString(getSaFibra(), "") +
                "," + Objects.toString(getSaLash(), "") +
                "," + Objects.toString(getIndicePresenca(), "") +
                "," + Objects.toString(getNomeDoNegocio(), "").replace(",", ";") +
                "," + Objects.toString(getWhatsAppAPP(), "") +
                "," + Objects.toString(getWhatsAppWEB(), "") +
                "," + Objects.toString(getOrigemGendo(), "") +
                "," + Objects.toString(getPipeline(), "");
    }

    @Override
    public DTOType getType() {
        return DTOType.AGENDAMENTO;
    }
}
