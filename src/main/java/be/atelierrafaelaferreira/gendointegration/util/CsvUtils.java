package be.atelierrafaelaferreira.gendointegration.util;

import be.atelierrafaelaferreira.gendointegration.model.dto.AgendamentoDTO;
import be.atelierrafaelaferreira.gendointegration.model.dto.ClienteDTO;
import be.atelierrafaelaferreira.gendointegration.model.dto.ComandaDTO;
import be.atelierrafaelaferreira.gendointegration.model.dto.CsvBaseDTO;
import be.atelierrafaelaferreira.gendointegration.model.dto.types.DTOType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvUtils {
    public static void generateCsv(List<? extends CsvBaseDTO> csvBaseDTOS, DTOType dtoType) throws IOException {

        String csv = getCsvHeader(dtoType) + "\n" +
                csvBaseDTOS.stream()
                        .map(CsvBaseDTO::toCsv)
                        .collect(Collectors.joining("\n"));

        Path path = Paths.get("resultado" + dtoType + ".csv");
        byte[] strToBytes = csv.getBytes();

        Files.write(path, strToBytes);
    }

    public static String getCsvHeader(DTOType dtoType) {
        return switch (dtoType) {
            case AGENDAMENTO -> AgendamentoDTO.getCsvHeader();
            case COMANDA -> ComandaDTO.getCsvHeader();
            case CLIENTE -> ClienteDTO.getCsvHeader();
        };
    }
}
