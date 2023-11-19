package be.atelierrafaelaferreira.gendointegration.model.entity.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.util.StringUtils;

import java.util.Arrays;

public enum Genero {

    MASCULINO(201, "M"),
    FEMININO(202, "F"),
    NAO_INFORMADO(0, "");

    private Integer cod;
    private String value;

    Genero(Integer cod, String value) {
        this.cod = cod;
        this.value = value;
    }

    public Integer getCod() {
        return cod;
    }

    public String getValue() {
        return value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Genero getInstance(@JsonProperty("sexo") String codString) {
        if (!StringUtils.hasText(codString)) {
            return NAO_INFORMADO;
        }
        Integer cod = Integer.valueOf(codString);
        return Arrays.stream(values())
                .filter(genero -> genero.getCod().equals(cod))
                .findAny()
                .orElse(NAO_INFORMADO);
    }
}
