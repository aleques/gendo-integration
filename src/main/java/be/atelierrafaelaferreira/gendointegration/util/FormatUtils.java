package be.atelierrafaelaferreira.gendointegration.util;

import java.util.Optional;

public class FormatUtils {
    public static String getFixedComentarios(String comentarios) {
        return Optional.ofNullable(comentarios)
                .filter(String::isBlank)
                .map(s -> s.replace(",", ";"))
                .map(s -> s.replaceAll("\\R+", " "))
                .orElse("");
    }
}
