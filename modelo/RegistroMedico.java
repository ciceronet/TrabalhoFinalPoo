package modelo;

import java.time.LocalDate;

public abstract class RegistroMedico {
    private final String descricao;
    private final LocalDate data;

    public RegistroMedico(String descricao) {
        this(descricao, LocalDate.now());
    }

    public RegistroMedico(String descricao, LocalDate data) {
        this.descricao = descricao;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract String gerarRelatorio();
}
