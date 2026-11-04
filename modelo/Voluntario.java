package modelo;
import exceptions.*;
public class Voluntario extends Usuario{
    public Voluntario (String email, String nome, String senha) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        super(email, nome, senha);
    }
    @Override 
    public void Menu() {
        int resposta;
        boolean rodando = true;
        while(rodando) {
            System.out.println("1 - Visualizar animais disponíveis para adoção");
            System.out.println("2 - Candidatar-se para atividade de apoio");
            System.out.println("3 - Animais sob sua responsabilidade");
            System.out.println("4 - Histórico de participações em ONG");
            switch (resposta) {
                case 1:
                
                    break;
        
                default:
                    break;
            }
        }
    }
}
