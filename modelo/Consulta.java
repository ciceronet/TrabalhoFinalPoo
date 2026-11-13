package modelo;

public class Consulta extends RegistroMedico { 
    private LocalDate data;
    public Consulta(LocalDate data, String descricao) {
        super(descricao);
        this.data = data;
    }
    @Override
    public String gerarRelatorio() {
        return "Consulta: " + getDescricao() + "\nData: " + data;
    }
}
