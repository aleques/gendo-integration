package be.atelierrafaelaferreira.gendointegration.util;

import be.atelierrafaelaferreira.gendointegration.model.entity.Agendamento;
import be.atelierrafaelaferreira.gendointegration.model.entity.Comanda;
import be.atelierrafaelaferreira.gendointegration.model.entity.PagamentoDetalhe;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class GendoUtils {
    public static Comanda getComanda(Agendamento agendamento, List<Comanda> comandas) {
        return comandas.stream()
                .filter(c -> c.getData().equals(agendamento.getData()) || agendamento.getData().equals(getDataPagamento(c)))
                .filter(c -> c.getIdPaciente().equals(agendamento.getIdPaciente()))
                .filter(c -> Objects.requireNonNullElse(c.getServicos(), "").contains(agendamento.getNomeServico().trim()))
                .findFirst()
                .orElse(null);
    }

    public static LocalDate getDataPagamento(Comanda c) {
        return Optional.ofNullable(c.getPagamentoDetalhes())
                .map(Map::values)
                .map(p -> p.stream().findFirst().orElse(null))
                .map(PagamentoDetalhe::getData)
                .orElse(null);
    }
}
