package be.atelierrafaelaferreira.gendointegration.model.dto;

import be.atelierrafaelaferreira.gendointegration.model.dto.types.DTOType;

public interface CsvBaseDTO {
    String toCsv();

    DTOType getType();
}
