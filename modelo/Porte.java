package modelo;

public enum Porte {
    PEQUENO("Pequeno"), MEDIO("Médio"), GRANDE("Grande");
    private final String descricao;
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public String toString() {
        return this.descricao;
    }
}
