package modelo;
import java.util.Scanner;
import exceptions.*;
import ui.*;
public class Admnistrador extends Usuario{
    public Admnistrador(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
    @Override 
    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        int resposta;
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Editar animal");
        System.out.println("3 - Remover Animal");
        System.out.println("4 - Solicitação de adoção");
        System.out.println("5 - Gerenciar Usuarios");
        System.out.println("6 - Cadastrar atividades");
        System.out.println("6 - Notificações");
        System.out.println("7 - relatórios");
        while(rodando) {
            System.out.println("Selecione a opção desejada");
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    TelaPrincipal.telaCriarAtividade();
                    break;
                case 7:

                    break;
                default:
                    break;
            }
        }


    }
}  
