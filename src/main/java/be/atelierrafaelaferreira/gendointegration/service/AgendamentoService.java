package be.atelierrafaelaferreira.gendointegration.service;

import be.atelierrafaelaferreira.gendointegration.mapper.AgendamentoMapper;
import be.atelierrafaelaferreira.gendointegration.model.dto.AgendamentoDTO;
import be.atelierrafaelaferreira.gendointegration.model.dto.CsvBaseDTO;
import be.atelierrafaelaferreira.gendointegration.model.dto.types.DTOType;
import be.atelierrafaelaferreira.gendointegration.model.entity.Agendamento;
import be.atelierrafaelaferreira.gendointegration.model.entity.EntityBase;
import be.atelierrafaelaferreira.gendointegration.util.CsvUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AgendamentoService {

    private ObjectMapper objectMapper;
    public void generateAgendamentoDTOs () throws IOException {

        final EntityBase<Agendamento> agendamentoRootAntesDeSetembroPag1 = objectMapper.readValue(this.getClass().getResourceAsStream("/import/agendamentos-2023-09-antes-pagina-1.json"), new TypeReference<>() {});
        final EntityBase<Agendamento> agendamentoRootAntesDeSetembroPag2 = objectMapper.readValue(this.getClass().getResourceAsStream("/import/agendamentos-2023-09-antes-pagina-2.json"), new TypeReference<>() {});
        final EntityBase<Agendamento> agendamentoRootAposSetembro = objectMapper.readValue(this.getClass().getResourceAsStream("/import/agendamentos-2023-09-depois.json"), new TypeReference<>() {});

        List<Agendamento> agendamentos = Stream.of(
                        agendamentoRootAntesDeSetembroPag1.getData(),
                        agendamentoRootAntesDeSetembroPag2.getData(),
                        agendamentoRootAposSetembro.getData())
                .flatMap(Collection::stream)
                .toList();

        final List<? extends CsvBaseDTO> agendamentoDTOS = AgendamentoMapper.toDtoList(agendamentos);
        CsvUtils.generateCsv(agendamentoDTOS, DTOType.AGENDAMENTO);
    }
}
