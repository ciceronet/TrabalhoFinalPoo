package modelo;
import exceptions.*;
public class Veterinario extends Usuario {
    public Veterinario(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
    @Override 
    public void Menu() {
        boolean rodando = true;
        int resposta;
        while (rodando) {
            System.out.println("1 - Registrar consultas e tratamentos");
            System.out.println("2 - Atualizar informações médicas dos animais");
            System.out.println("3 - Emitir relatórios de saúde dos animas");
            switch (resposta) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }
    }
}
