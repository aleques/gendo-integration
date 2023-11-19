package be.atelierrafaelaferreira.gendointegration.service;

import be.atelierrafaelaferreira.gendointegration.mapper.ClienteMapper;
import be.atelierrafaelaferreira.gendointegration.model.dto.CsvBaseDTO;
import be.atelierrafaelaferreira.gendointegration.model.dto.types.DTOType;
import be.atelierrafaelaferreira.gendointegration.model.entity.Cliente;
import be.atelierrafaelaferreira.gendointegration.model.entity.EntityBase;
import be.atelierrafaelaferreira.gendointegration.util.CsvUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ObjectMapper objectMapper;
    public void generateClienteDTOs () throws IOException {

        final EntityBase<Cliente> clientesRoot = objectMapper.readValue(this.getClass().getResourceAsStream("/import/clientes.json"), new TypeReference<>() {});

        final List<? extends CsvBaseDTO> clienteDTOS = ClienteMapper.toDtoList(clientesRoot.getData());
        CsvUtils.generateCsv(clienteDTOS, DTOType.CLIENTE);
    }
}
