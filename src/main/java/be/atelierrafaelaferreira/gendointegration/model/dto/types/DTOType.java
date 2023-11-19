package be.atelierrafaelaferreira.gendointegration.model.dto.types;

public enum DTOType {
    AGENDAMENTO("Agendamento"),
    COMANDA("Comanda"),

    CLIENTE("Cliente");

    private String value;
    DTOType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
