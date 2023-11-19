package be.atelierrafaelaferreira.gendointegration.model.entity.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum StatusAgendamento {

    NOVO_AGENDAMENTO(1, "Novo Agendamento"),
    CONFIRMADO(2, "Confirmado"),
    FINALIZADO(3, "Finalizado"),
    REMARCADO(4, "Remarcado"),
    RETORNO(5, "Retorno"),
    CLIENTE_CHEGOU(6, "Cliente Chegou"),
    CANCELADO(7, "Cancelado"),
    EM_ANALISE(8, "Em Analise"),
    FALTOU(9, "Faltou"),
    REMOVIDO(10, "Removido"),
    PAGSEGURO_NAO_PAGO(11, "PagSeguro Nao Pago");

    private int status;

    private String value;

    StatusAgendamento(int status, String value) {
        this.status = status;
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static StatusAgendamento getInstance(@JsonProperty("status") String statusString) {
        Integer status = Integer.valueOf(statusString);
        return Arrays.stream(values())
                .filter(statusAgendamento -> statusAgendamento.getStatus() == status)
                .findAny()
                .orElse(null);
    }
}
