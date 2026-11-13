package modelo;

public class Medicamento extends RegistroMedico{
    public Medicamento(String nome) {
        super(nome);
    }
    @Override
    public String gerarRelatorio() {
        return "Medicamento: " + nome;
    }
}
