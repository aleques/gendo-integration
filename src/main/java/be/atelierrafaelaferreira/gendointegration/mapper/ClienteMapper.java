package be.atelierrafaelaferreira.gendointegration.mapper;

import be.atelierrafaelaferreira.gendointegration.model.dto.ClienteDTO;
import be.atelierrafaelaferreira.gendointegration.model.entity.Cliente;
import be.atelierrafaelaferreira.gendointegration.model.entity.types.Genero;

import java.util.List;
import java.util.Objects;

import static be.atelierrafaelaferreira.gendointegration.util.ClienteUtils.getPrimeiroNome;
import static be.atelierrafaelaferreira.gendointegration.util.ClienteUtils.getQtdAgendamentos;
import static be.atelierrafaelaferreira.gendointegration.util.ClienteUtils.getSobrenome;
import static be.atelierrafaelaferreira.gendointegration.util.FormatUtils.getFixedComentarios;

public class ClienteMapper {

    public static ClienteDTO toDto(Cliente c) {
        return ClienteDTO.builder()
                .idCliente(c.getId())
                .nomeCompleto(c.getNome())
                .nome(getPrimeiroNome(c.getNome()))
                .sobrenome(getSobrenome(c.getNome()))
                .dataDeNascimento(c.getDataNascimento())
                .genero(Objects.requireNonNullElse(c.getSexo(), Genero.NAO_INFORMADO).toString())
                .eMail(c.getId() + "@atelierrafaelaferreira.be")
                .numeroDeCelular(c.getTelefone())
                .observacao(getFixedComentarios(c.getDescricao()))
                .agendamentos(getQtdAgendamentos(c))
                .ausencias(Objects.requireNonNullElse(c.getFaltas(),0))
        .build();
    }

    public static List<ClienteDTO> toDtoList(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteMapper::toDto)
                .toList();
    }
}
