package modelo;

public class Tratamento extends RegistroMedico {
    public Tratamento(String descricao) {
        super(descricao);
    }

    @Override
    public String gerarRelatorio() {
        return "Tratamento: " + getDescricao() + " | Início: " + getData();
    }
}
