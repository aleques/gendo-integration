package be.atelierrafaelaferreira.gendointegration.mapper;

import be.atelierrafaelaferreira.gendointegration.model.dto.AgendamentoDTO;
import be.atelierrafaelaferreira.gendointegration.model.entity.Agendamento;
import be.atelierrafaelaferreira.gendointegration.util.ServicoUtils;

import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;

import static be.atelierrafaelaferreira.gendointegration.util.AgendamentoUtils.getFixedAgendamentoValorTotal;
import static be.atelierrafaelaferreira.gendointegration.util.AgendamentoUtils.getIndicePresenca;
import static be.atelierrafaelaferreira.gendointegration.util.AgendamentoUtils.getLastAgendamentoData;
import static be.atelierrafaelaferreira.gendointegration.util.FormatUtils.getFixedComentarios;

public class AgendamentoMapper {

    public static AgendamentoDTO toDto(Agendamento a, List<Agendamento> agendamentos) {
        return AgendamentoDTO.builder()
                .id(a.getId())
                .idPaciente(a.getIdPaciente())
                .idResponsavel(a.getIdResponsavel())
                .data(a.getData())
                .horaInicio(a.getHoraInicio())
                .horaFim(a.getHoraFim())
                .valorTotal(getFixedAgendamentoValorTotal(a.getValorTotal()))
                .status(a.getStatus())
                .idServico(a.getIdServico())
                .comentario(getFixedComentarios(a.getComentario()))
                .categoria(a.getCategoria())
                .nomePaciente(a.getNomePaciente())
                .telefone(a.getTelefone())
                .email(a.getIdPaciente() + "@atelierrafaelaferreira.be")
                .nomeResponsavel(a.getNomeResponsavel())
                .nomeServico(a.getNomeServico())
                .subcadastroDescricao(a.getSubcadastroDescricao())
                .servicosAdicionais(a.getServicosAdicionais())
                .dataUltimoAgendamento(getLastAgendamentoData(a, agendamentos))
                .dataAno(a.getData().getYear())
                .dataMes("'" + String.format("%02d", a.getData().getMonthValue()) + " - " + a.getData().getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH))
                .dataSemana(a.getData().get(ChronoField.ALIGNED_WEEK_OF_YEAR))
                .dataDia(a.getData().getDayOfMonth())
                .valorTotal90(a.getValorTotal() * 0.9)
                .saFibra(ServicoUtils.hasFibra(a, agendamentos))
                .saLash(ServicoUtils.hasLash(a, agendamentos))
                .indicePresenca(getIndicePresenca(a, agendamentos))
                .nomeDoNegocio(a.getNomePaciente() + " - " + a.getNomeServico())
                .whatsAppAPP("https://api.whatsapp.com/send/?phone=" + a.getTelefone())
                .whatsAppWEB("https://web.whatsapp.com/send?phone=" + a.getTelefone())
                .origemGendo("Sim")
                .pipeline("Pipeline de vendas")
                .build();
    }

    public static List<AgendamentoDTO> toDtoList(List<Agendamento> agendamentos) {
        return agendamentos.stream()
                .map(a -> toDto(a, agendamentos))
                .toList();
    }
}
