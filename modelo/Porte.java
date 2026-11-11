package modelo;

public class Porte {
     PEQUENO("Pequeno"), MEDIO("Médio"), GRANDE("Grande");
    private final String descricao;
    Porte(String descricao) {
        
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    public String toString() {
        return this.descricao;
    }
}
