package be.atelierrafaelaferreira.gendointegration;

import be.atelierrafaelaferreira.gendointegration.model.entity.Agendamento;
import be.atelierrafaelaferreira.gendointegration.model.entity.AgendamentoComanda;
import be.atelierrafaelaferreira.gendointegration.model.entity.Comanda;
import be.atelierrafaelaferreira.gendointegration.model.entity.EntityBase;
import be.atelierrafaelaferreira.gendointegration.service.AgendamentoService;
import be.atelierrafaelaferreira.gendointegration.service.ClienteService;
import be.atelierrafaelaferreira.gendointegration.util.ServicoUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static be.atelierrafaelaferreira.gendointegration.util.GendoUtils.getComanda;

class GendoIntegrationUnitTests {

    private static ObjectMapper objectMapper;
    @BeforeAll
    public static void init() {
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    }

    @Test
    void testTotalAgendamentoComandas() throws IOException {

        final EntityBase<Agendamento> agendamentoRootAntesDeSetembroPag1 = objectMapper.readValue(this.getClass().getResourceAsStream("/agendamentos-2023-09-antes-pagina-1.json"), new TypeReference<>() {});
        final EntityBase<Agendamento> agendamentoRootAntesDeSetembroPag2 = objectMapper.readValue(this.getClass().getResourceAsStream("/agendamentos-2023-09-antes-pagina-2.json"), new TypeReference<>() {});
        final EntityBase<Agendamento> agendamentoRootAposSetembro = objectMapper.readValue(this.getClass().getResourceAsStream("/agendamentos-2023-09-depois.json"), new TypeReference<>() {});
        final EntityBase<Comanda> comandaRootAntesDeSetembro = objectMapper.readValue(this.getClass().getResourceAsStream("/comandas-2023-09-antes.json"), new TypeReference<>() {});
        final EntityBase<Comanda> comandaRootAposSetembro = objectMapper.readValue(this.getClass().getResourceAsStream("/comandas-2023-09-depois.json"), new TypeReference<>() {});

        List<Agendamento> agendamentos = Stream.of(
                agendamentoRootAntesDeSetembroPag1.getData(),
                agendamentoRootAntesDeSetembroPag2.getData(),
                agendamentoRootAposSetembro.getData())
             .flatMap(Collection::stream)
            .toList();
        List<Comanda> comandas = Stream.of(
                comandaRootAntesDeSetembro.getData(),
                comandaRootAposSetembro.getData())
            .flatMap(Collection::stream)
            .toList();

        final List<AgendamentoComanda> result = agendamentos.stream()
            .map(a -> new AgendamentoComanda(a, getComanda(a, comandas)))
            .toList();

        //generateCsv(result);
    }
    @Test
    void testComandas() throws IOException {

        final EntityBase<Agendamento> agendamentoRootAntesDeSetembroPag1 = objectMapper.readValue(this.getClass().getResourceAsStream("/agendamentos-2023-09-antes-pagina-1.json"), new TypeReference<>() {});
        final EntityBase<Agendamento> agendamentoRootAntesDeSetembroPag2 = objectMapper.readValue(this.getClass().getResourceAsStream("/agendamentos-2023-09-antes-pagina-2.json"), new TypeReference<>() {});
        final EntityBase<Agendamento> agendamentoRootAposSetembro = objectMapper.readValue(this.getClass().getResourceAsStream("/agendamentos-2023-09-depois.json"), new TypeReference<>() {});
        final EntityBase<Comanda> comandaRootAntesDeSetembro = objectMapper.readValue(this.getClass().getResourceAsStream("/comandas-2023-09-antes.json"), new TypeReference<>() {});
        final EntityBase<Comanda> comandaRootAposSetembro = objectMapper.readValue(this.getClass().getResourceAsStream("/comandas-2023-09-depois.json"), new TypeReference<>() {});

        List<Agendamento> agendamentos = Stream.of(
                        agendamentoRootAntesDeSetembroPag1.getData(),
                        agendamentoRootAntesDeSetembroPag2.getData(),
                        agendamentoRootAposSetembro.getData())
                .flatMap(Collection::stream)
                .toList();
        List<Comanda> comandas = Stream.of(
                        comandaRootAntesDeSetembro.getData(),
                        comandaRootAposSetembro.getData())
                .flatMap(Collection::stream)
                .toList();

        final List<AgendamentoComanda> result = agendamentos.stream()
                .map(a -> new AgendamentoComanda(a, getComanda(a, comandas)))
                .toList();

        //generateCsv(result);
    }

    @Test
    void testClientes() throws IOException {
        new ClienteService(objectMapper).generateClienteDTOs();
    }

    @Test
    void testAgendamentos() throws IOException {
        new AgendamentoService(objectMapper).generateAgendamentoDTOs();
    }
}
