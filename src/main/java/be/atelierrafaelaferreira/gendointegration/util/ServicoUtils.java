package be.atelierrafaelaferreira.gendointegration.util;

import be.atelierrafaelaferreira.gendointegration.model.entity.Agendamento;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ServicoUtils {

    private static final List<String> FIBRA_LIST = List.of(
            "Fibra | Aplicação",
            "Fibra | Aplicação | Promocional",
            "Fibra | Aplicação Nail Art/Francesinha",
            "Fibra | Aplicação promocional 50 €",
            "Fibra | Manutenção",
            "Fibra | Manutenção ",
            "Fibra | Manutenção | Promocional",
            "Fibra | Manutenção Nail Art/Francesinha",
            "Fibra | Remoção ",
            "SD - Aplicação | Fibra",
            "SD - Aplicação de fibra",
            "SD - Fibra | Aplicação",
            "SD - Fibra | Aplicação ",
            "SD - Fibra | Manutenção",
            "Unha | Molde Russo  Aplicação",
            "Unha | Molde Russo Manutenção"
    );

    private static final List<String> LASH_LIST = List.of(
    "Brow Lamination | PROMOÇÃO",
            "Brows Lamination + Lash Lifting",
            "COMBO | Cílios e Limpeza de pele",
            "Ext | Fio a fio | Aplicação",
            "Ext | Fio a fio | Retoque",
            "Ext | Mega Volume | Retoque",
            "Ext | Volume Brasileiro | Aplicação ",
            "Ext | Volume Brasileiro | Retoque",
            "Ext | Volume Egípcio | Aplicação ",
            "Ext | Volume Egípcio | Aplicação I Promocional",
            "Ext | Volume Egípcio | Retoque",
            "Ext | Volume Fox Eyes | Aplicação",
            "Ext | Volume Russo  | Aplicação ",
            "Ext | Volume Russo  | Retoque",
            "Extensão Capping",
            "Extensão Mega Volume",
            "Extensão Mega Volume I Retoque",
            "Lash Lifting",
            "Limpeza de Pele",
            "PROMO | Cílios  - Bra; Egip; class 50€",
            "Promoção Cílios vol. Brasileiro",
            "Remoçao Cilios",
            "SD-Ext | Fio a fio | Aplicação",
            "SD-Ext | Volume Russo | Aplicação",
            "Sobrancelha - Linha ou Pinça",
            "Sobrancelha com depilação rosto",
            "Sobrancelha com henna",
            "Sobrancelha com henna + depilação rosto ",
            "Sobrancelha Pinça",
            "Sobrancelha Tradicional"
    );

    public static boolean hasFibra(Agendamento agendamento, List<Agendamento> agendamentos) {
        return isService(FIBRA_LIST, agendamento, agendamentos);
    }
    public static boolean hasLash(Agendamento agendamento, List<Agendamento> agendamentos) {
        return isService(LASH_LIST, agendamento, agendamentos);
    }

    private static boolean isService(List<String> servicosList, Agendamento agendamento, List<Agendamento> agendamentos) {

        final int idPaciente = Optional.ofNullable(agendamento.getIdPaciente())
                .orElse(-1);

        return agendamentos.stream()
                .filter(a -> a.getIdPaciente() == idPaciente)
                .flatMap(a -> Stream.concat(List.of(a.getNomeServico()).stream(), getServicosAdicionaisList(a.getServicosAdicionais()).stream()))
                .anyMatch(servicosList::contains);
    }
    private static List<String> getServicosAdicionaisList(String servicosAdicionais) {

        if (servicosAdicionais == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(servicosAdicionais.split(";"))
                .filter(String::isBlank)
                .map(String::trim)
                .toList();
    }
}
