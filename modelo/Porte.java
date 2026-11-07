package modelo;

public enum Porte {
    PEQUENO("Pequeno"), MEDIO("Médio"), GRANDE("Grande");
    private final String descricao;
    Porte(String descricao) {
        this.descricao = descricao;
        //TODO Auto-generated constructor stub
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    public String toString() {
        return this.descricao;
    }
}