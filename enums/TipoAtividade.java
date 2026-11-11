package enums;

public enum TipoAtividade {
    MUTIRAO_LIMPEZA("Mutirão de limpeza"),
    CAMPANHA_VACINACAO("Campanhas de vacinação"),
    FEIRA_ADOCAO("Feiras de adoção"),
    EVENTO_BENEFICENTE("Eventos beneficentes");

    private final String descricao;

    TipoAtividade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    public String tString() {
        return descricao;
    }
    
}
