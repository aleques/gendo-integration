package be.atelierrafaelaferreira.gendointegration.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class EntityBase<T> {

    private boolean status;
    private String message;
    private String datetime;
    private List<T> data;
}
