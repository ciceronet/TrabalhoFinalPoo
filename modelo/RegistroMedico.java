package modelo;
public abstract class RegistroMedico {
    private String descricao;
    public RegistroMedico(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract String gerarRelatorio();
}