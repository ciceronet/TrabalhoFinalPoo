package modelo;
import exceptions.*;
import java.util.Scanner;
public class Veterinario extends Usuario {
    Scanner scan = new Scanner(System.in);
    public Veterinario(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
    @Override 
    public void Menu() {
        boolean rodando = true;
        int resposta;
        System.out.println("1 - Registrar consultas e tratamentos");
        System.out.println("2 - Atualizar informações médicas dos animais");
        System.out.println("3 - Emitir relatórios de saúde dos animas");
        while (rodando) {
            System.out.println("Selecione a opção que deseja");
            resposta = scan.nextInt();
            switch (resposta) {
                case 1:
                    rodando = false;

                break;
                case 2:
                    rodando = false;

                break;
                case 3:
                    rodando = false;

                break;
                case 4:
                    rodando = false;
                    
                break;
                default:
                    System.out.println("Opção Inválida!!");
                break;
            }
        }
    }
    @Override
    public String getTipoUsuario() {
        throw new UnsupportedOperationException("Unimplemented method 'getTipoUsuario'");
    }
}
