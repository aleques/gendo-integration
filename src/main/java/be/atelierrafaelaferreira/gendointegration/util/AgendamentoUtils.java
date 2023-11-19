package be.atelierrafaelaferreira.gendointegration.util;

import be.atelierrafaelaferreira.gendointegration.model.entity.Agendamento;
import be.atelierrafaelaferreira.gendointegration.model.entity.types.StatusAgendamento;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AgendamentoUtils {

    public static LocalDate getLastAgendamentoData(Agendamento agendamento, List<Agendamento> agendamentos) {

        final List<Agendamento> agendamentosDoMesmoCliente = getAgendamentosDoMesmoCliente(agendamento, agendamentos);

        return agendamentosDoMesmoCliente.stream()
                .map(Agendamento::getData)
                .max(LocalDate::compareTo)
                .orElse(null);
    }

    public static Integer getIndicePresenca(Agendamento agendamento, List<Agendamento> agendamentos) {

        final List<Agendamento> agendamentosDoMesmoCliente = getAgendamentosDoMesmoCliente(agendamento, agendamentos);
        long totalFinalizados = agendamentosDoMesmoCliente.stream()
                                .filter(a -> a.getStatus() == StatusAgendamento.FINALIZADO)
                                .count();

        long totalCanceladosOuFaltas = agendamentosDoMesmoCliente.stream()
                .filter(a -> a.getStatus() == StatusAgendamento.CANCELADO || a.getStatus() == StatusAgendamento.FALTOU)
                .count();

        long total = totalFinalizados + totalCanceladosOuFaltas;
        if (total == 0) {
            return null;
        }

        return (int) (totalFinalizados * 100 / total);
    }

    public static Double getFixedAgendamentoValorTotal(Double valorTotal) {

        if (valorTotal == null) {
            return null;
        } else if (valorTotal > 1000) {
            return valorTotal / 100;
        } else if (List.of(299,399,499).contains(valorTotal.intValue())) {
            return valorTotal / 10;
        } else {
            return valorTotal;
        }
    }



    private static List<Agendamento> getAgendamentosDoMesmoCliente(Agendamento agendamento, List<Agendamento> agendamentos) {
        final int idPaciente = Optional.ofNullable(agendamento.getIdPaciente())
                .orElse(-1);

        return agendamentos.stream()
                .filter(a -> a.getIdPaciente() == idPaciente)
                .toList();
    }
}
