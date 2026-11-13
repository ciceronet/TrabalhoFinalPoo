package modelo;
import exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;
public class Veterinario extends Usuario {;		
    Scanner scan = new Scanner(System.in);
    public Veterinario(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
   
     @Override
    public String getTipoUsuario() {
        return "Veterinário";
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public void Menu(ArrayList<Animais> cadastrados,ArrayList<Animais> adotados,ArrayList<Animais> tratando,ArrayList<Voluntario> voluntarios, ArrayList<Veterinario> veterinarios,ArrayList<Atividade> eventos, ArrayList<Notificacao> notifica,ArrayList<SolicitacaoAdocao>solicitacoes,Scanner sc) {

        

        boolean rodando = true;

        while (rodando) {

            System.out.println("\n===== MENU VETERINÁRIO =====");
            System.out.println("1 - Registrar consulta");
            System.out.println("2 - Atualizar informações médicas");
            System.out.println("3 - Emitir relatório de saúde");
            System.out.println("0 - Sair");

            int resposta = sc.nextInt();
            sc.nextLine();

            switch (resposta) {

                case 1:
                    System.out.println("Funcionalidade de consultas.");
                    break;

                case 2:
                    System.out.println("Funcionalidade de atualização médica.");
                    break;

                case 3:
                    System.out.println("Funcionalidade de relatórios.");
                    break;

                case 0:
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        }

    }

    
}
