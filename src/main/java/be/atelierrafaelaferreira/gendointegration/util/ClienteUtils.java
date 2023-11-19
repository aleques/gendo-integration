package be.atelierrafaelaferreira.gendointegration.util;

import be.atelierrafaelaferreira.gendointegration.model.entity.Cliente;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteUtils {

    public static Integer getQtdAgendamentos(Cliente cliente) {
        final Integer visitas = Optional.ofNullable(cliente.getVisitas()).orElse(0);
        final Integer faltas = Optional.ofNullable(cliente.getFaltas()).orElse(0);
        return visitas + faltas;
    }

    public static String getPrimeiroNome(String nomeCompleto) {
        Pattern pattern = Pattern.compile("^(\\S\\s-\\s)?[^\\s]+");
        Matcher matcher = pattern.matcher(nomeCompleto);
        matcher.find();
        return matcher.group(0);
    }

    public static String getSobrenome(String nomeCompleto) {
        Pattern pattern = Pattern.compile("^(\\S\\s-\\s)?[^\\s]+");
        Matcher matcher = pattern.matcher(nomeCompleto);
        matcher.find();
        final String sobrenome = nomeCompleto.substring(matcher.end()).trim();
        return StringUtils.hasText(sobrenome) ? sobrenome : null;
    }
}
