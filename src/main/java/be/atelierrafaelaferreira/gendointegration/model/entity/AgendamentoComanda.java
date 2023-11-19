package be.atelierrafaelaferreira.gendointegration.model.entity;

import lombok.Value;

import java.util.Objects;

@Value
public class AgendamentoComanda {

    private Agendamento agendamento;
    private Comanda comanda;

    public static String getCsvHeader() {
        return
                 "AgendamentoId" +
                ",AgendamentoIdPaciente" +
                ",AgendamentoIdResponsavel" +
                ",AgendamentoData" +
                ",AgendamentoHoraInicio" +
                ",AgendamentoHoraFim" +
                ",AgendamentoIdPagamento" +
                ",AgendamentoValorTotal" +
                ",AgendamentoStatus" +
                ",AgendamentoStatusPagamento" +
                ",AgendamentoIdServico" +
                ",AgendamentoComentario" +
                ",AgendamentoUid" +
                ",AgendamentoDataAtualizacao" +
                ",AgendamentoSequencia" +
                ",AgendamentoDataCriacao" +
                ",AgendamentoLembrete" +
                ",AgendamentoLembrado" +
                ",AgendamentoIdObject" +
                ",AgendamentoCanalOrigem" +
                ",AgendamentoCategoria" +
                ",AgendamentoNomePaciente" +
                ",AgendamentoTelefone" +
                ",AgendamentoEmail" +
                ",AgendamentoNomeResponsavel" +
                ",AgendamentoNomeServico" +
                ",AgendamentoSubcadastroDescricao" +
                ",AgendamentoServicosAdicionais" +

                ",ComandaId" +
                ",ComandaData" +
                ",ComandaIdPaciente" +
                ",ComandaTotal" +
                ",ComandaSaldo" +
                ",ComandaStatus" +
                ",ComandaIdCaixa" +
                ",ComandaDesconto" +
                ",ComandaPrePago" +
                ",ComandaDataLiberaca" +
                ",ComandaLiberada" +
                ",ComandaTaxaCartao" +
                ",ComandaTaxas" +
                ",ComandaCodigo" +
                ",ComandaObservacoes" +
                ",ComandaNotaFiscal" +
                ",ComandaPacienteNome" +
                ",ComandaTelefone" +
                ",ComandaServicos" +

                ",PagamentoData" +
                ",PagamentoVencimento" +
                ",PagamentoValor" +
                ",PagamentoDescricao";
    }

    public String toCsv() {

        String values = Objects.toString(agendamento.getId(), "") +
                "," + Objects.toString(agendamento.getIdPaciente(), "") +
                "," + Objects.toString(agendamento.getIdResponsavel(), "") +
                "," + Objects.toString(agendamento.getData(), "") +
                "," + Objects.toString(agendamento.getHoraInicio(), "") +
                "," + Objects.toString(agendamento.getHoraFim(), "") +
                "," + Objects.toString(agendamento.getIdPagamento(), "") +
                "," + Objects.toString(agendamento.getValorTotal(), "") +
                "," + Objects.toString(agendamento.getStatus(), "") +
                "," + Objects.toString(agendamento.getStatusPagamento(), "") +
                "," + Objects.toString(agendamento.getIdServico(), "") +
                "," + Objects.toString(agendamento.getComentario(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getUid(), "") +
                "," + Objects.toString(agendamento.getDataAtualizacao(), "") +
                "," + Objects.toString(agendamento.getSequencia(), "") +
                "," + Objects.toString(agendamento.getDataCriacao(), "") +
                "," + Objects.toString(agendamento.getLembrete(), "") +
                "," + Objects.toString(agendamento.getLembrado(), "") +
                "," + Objects.toString(agendamento.getIdObject(), "") +
                "," + Objects.toString(agendamento.getCanalOrigem(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getCategoria(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getNomePaciente(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getTelefone(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getEmail(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getNomeResponsavel(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getNomeServico(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getSubcadastroDescricao(), "").replace(",", ";") +
                "," + Objects.toString(agendamento.getServicosAdicionais(), "").replace(",", ";");

        if (comanda != null) {

            values += "," + Objects.toString(comanda.getId(), "") +
                "," + Objects.toString(comanda.getData(), "") +
                "," + Objects.toString(comanda.getIdPaciente(), "") +
                "," + Objects.toString(comanda.getTotal(), "") +
                "," + Objects.toString(comanda.getSaldo(), "") +
                "," + Objects.toString(comanda.getStatus(), "") +
                "," + Objects.toString(comanda.getIdCaixa(), "") +
                "," + Objects.toString(comanda.getDesconto(), "") +
                "," + Objects.toString(comanda.getPrePago(), "") +
                "," + Objects.toString(comanda.getDataLiberacao(), "").replace(",", ";") +
                "," + Objects.toString(comanda.getLiberada(), "") +
                "," + Objects.toString(comanda.getTaxaCartao(), "") +
                "," + Objects.toString(comanda.getTaxas(), "") +
                "," + Objects.toString(comanda.getCodigo(), "").replace(",", ";") +
                "," + Objects.toString(comanda.getObservacoes(), "").replace(",", ";") +
                "," + Objects.toString(comanda.getNotaFiscal(), "").replace(",", ";") +
                "," + Objects.toString(comanda.getPacienteNome(), "").replace(",", ";") +
                "," + Objects.toString(comanda.getTelefone(), "").replace(",", ";") +
                "," + Objects.toString(comanda.getServicos(), "").replace(",", ";");

            if (comanda.getPagamentoDetalhes() != null && !comanda.getPagamentoDetalhes().isEmpty()) {

                PagamentoDetalhe pagamentoDetalhe = comanda.getPagamentoDetalhes().values().stream().findFirst().orElse(null);

                values += "," + Objects.toString(pagamentoDetalhe.getData(), "") +
                    "," + Objects.toString(pagamentoDetalhe.getVencimento(), "") +
                    "," + Objects.toString(pagamentoDetalhe.getValor(), "") +
                    "," + Objects.toString(pagamentoDetalhe.getDescricao(), "").replace(",", ";");
            }
        }
        return values;
    }
}
