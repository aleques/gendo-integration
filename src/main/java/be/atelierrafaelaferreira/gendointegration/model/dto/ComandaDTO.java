package be.atelierrafaelaferreira.gendointegration.model.dto;

import be.atelierrafaelaferreira.gendointegration.model.dto.types.DTOType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Data
@Builder
public class ComandaDTO implements CsvBaseDTO {
    private Integer id;
    private LocalDate data;
    private Integer idPaciente;
    private Double total;
    private Double saldo;
    private Integer status;
    private Double desconto;
    private Integer prePago;
    private String dataLiberacao;
    private Integer liberada;
    private Double taxaCartao;
    private Double taxas;
    private Integer codigo;
    private String observacoes;
    private String pacienteNome;
    private String telefone;
    private String servicos;
    private Map<Integer, PagamentoDTO> pagamentoMap;

    public static String getCsvHeader() {
        return "ComandaId" +
            ",ComandaData" +
            ",ComandaIdPaciente" +
            ",ComandaTotal" +
            ",ComandaSaldo" +
            ",ComandaStatus" +
            ",ComandaDesconto" +
            ",ComandaPrePago" +
            ",ComandaDataLiberaca" +
            ",ComandaLiberada" +
            ",ComandaTaxaCartao" +
            ",ComandaTaxas" +
            ",ComandaCodigo" +
            ",ComandaObservacoes" +
            ",ComandaPacienteNome" +
            ",ComandaTelefone" +
            ",ComandaServicos" +

            ",PagamentoData" +
            ",PagamentoVencimento" +
            ",PagamentoValor" +
            ",PagamentoDescricao";
    }

    @Override
    public String toCsv() {

        String values = getCsvHeader() + "\n" +
                Objects.toString(getId(), "") +
                "," + Objects.toString(getData(), "") +
                "," + Objects.toString(getIdPaciente(), "") +
                "," + Objects.toString(getTotal(), "") +
                "," + Objects.toString(getSaldo(), "") +
                "," + Objects.toString(getStatus(), "") +
                "," + Objects.toString(getDesconto(), "") +
                "," + Objects.toString(getPrePago(), "") +
                "," + Objects.toString(getDataLiberacao(), "").replace(",", ";") +
                "," + Objects.toString(getLiberada(), "") +
                "," + Objects.toString(getTaxaCartao(), "") +
                "," + Objects.toString(getTaxas(), "") +
                "," + Objects.toString(getCodigo(), "").replace(",", ";") +
                "," + Objects.toString(getObservacoes(), "").replace(",", ";") +
                "," + Objects.toString(getPacienteNome(), "").replace(",", ";") +
                "," + Objects.toString(getTelefone(), "").replace(",", ";") +
                "," + Objects.toString(getServicos(), "").replace(",", ";");

        if (getPagamentoMap() != null && !getPagamentoMap().isEmpty()) {

            PagamentoDTO pagamentoDetalhe = getPagamentoMap().values().stream().findFirst().orElse(null);

            values += "," + Objects.toString(pagamentoDetalhe.getData(), "") +
                    "," + Objects.toString(pagamentoDetalhe.getVencimento(), "") +
                    "," + Objects.toString(pagamentoDetalhe.getValor(), "") +
                    "," + Objects.toString(pagamentoDetalhe.getDescricao(), "").replace(",", ";");
        }
        return values;
    }

    @Override
    public DTOType getType() {
        return DTOType.COMANDA;
    }
}
