package modelo;

public class Vacina extends RegistroMedico { 
    public Vacina( String nome) {
        super(nome);
    }
    @Override
    public String gerarRelatorio() {
        return "Vacina: " + nome;
    }
}
