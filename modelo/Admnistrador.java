package modelo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import exceptions.*;
import ui.TelaPrincipal;

public class Admnistrador extends Usuario{
      public Admnistrador(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
    int contador=0;
    Scanner scanner = new Scanner(System.in);
    @SuppressWarnings("unused")
    @Override 
    public void Menu(ArrayList<Animais> cadastrados , ArrayList<Animais> adotados , ArrayList<Animais> tratando ,ArrayList<Voluntario> voluntarios , ArrayList<Veterinario> veterinarios,ArrayList<Atividade> eventos) {
        
    boolean rodando = true;
    int resposta;
    while (rodando) {
    System.out.println("          Menu        ");
    System.out.println("1 - Gerenciar Animais");
    System.out.println("2 - Solicitações de adoção");
    System.out.println("3 - Gerenciar Usuarios");
    System.out.println("4 - Notificações");
    System.out.println("5 - Relatórios");
    System.out.println("6 - Estatisticas");
    System.out.println("7 - Cadastrar Atividade");
    System.out.println("0 - Sair");
    System.out.println("Selecione a opção desejada:");
    
    try {
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
                System.out.println("1 - Animais Resgatados");
                System.out.println("2 - Adoções realizadas");
                System.out.println("3 - Animais em tratamento");
                System.out.println("4 - Voluntarios Ativos");
                System.out.println("5 - Eventos Realizados");
                System.out.println("Selecione a sub-opção:");
                int opcao = scanner.nextInt();
                    switch (opcao) {
                        case 1:
                            for (Animais u : cadastrados) {
                                System.out.print("Nome:"+u.getNome()+" ");
                                System.out.print("Especie:"+u.getEspecie()+" ");
                                System.out.print("Raca:"+u.getRaca()+" ");
                                System.out.print("Idade:"+u.getIdade()+" ");
                                System.out.print("Porte:"+u.getPorte()+" ");
                                System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                                System.out.print("Status:"+u.getStatus()+" ");
                                System.out.println();
                            }
                            break;
                        case 2:
                            for (Animais u : adotados) {
                                System.out.print("Nome:"+u.getNome()+" ");
                                System.out.print("Especie:"+u.getEspecie()+" ");
                                System.out.print("Raca:"+u.getRaca()+" ");
                                System.out.print("Idade:"+u.getIdade()+" ");
                                System.out.print("Porte:"+u.getPorte()+" ");
                                System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                                System.out.print("Status:"+u.getStatus()+" ");
                                System.out.println();
                            }
                            break;
                        case 3:
                            for (Animais u : tratando) {
                                System.out.print("Nome:"+u.getNome()+" ");
                                System.out.print("Especie:"+u.getEspecie()+" ");
                                System.out.print("Raca:"+u.getRaca()+" ");
                                System.out.print("Idade:"+u.getIdade()+" ");
                                System.out.print("Porte:"+u.getPorte()+" ");
                                System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                                System.out.print("Status:"+u.getStatus()+" ");
                                System.out.println();
                            }
                            break;
                        case 4:
                            for (Voluntario u : voluntarios) {
                                System.out.print("Nome do Voluntario:"+u.getNome()+" ");
                                System.out.print("Email:"+u.getEmail()+" ");
                                System.out.println();
                            }
                            break;
                        case 5:
                            for (Atividade u : eventos) {
                                System.out.print("Nome do evento:"+u.getTipo()+" ");
                                System.out.print("Data do evento:"+u.getData()+" ");
                                System.out.print("Vagas:"+u.getVagas()+" ");
                                System.out.println();
                            }
                            break;
                        default:
                            System.out.println("Opção de relatório inválida!");
                            break;
                    }
                break; 

            case 6:
                int totalCadastrados = 0;
                int totalAdotados = 0;
                int totalTratando = 0;
                int totalVoluntarios = 0;
                int totalVeterinarios = 0;
                int taxa = 0;

                for(Animais u : cadastrados){
                    totalCadastrados++;
                }
                System.out.println("Animais cadastrados: " + totalCadastrados);

                for(Animais u : adotados){
                    totalAdotados++;
                }
                
                if (totalCadastrados > 0) {
                    taxa = (totalAdotados * 100) / totalCadastrados;
                }
                
                System.out.println("Animais adotados: " + totalAdotados);

                for(Animais u : tratando){
                    totalTratando++;
                }
                System.out.println("Animais em tratamento: " + totalTratando);

                for(Voluntario u : voluntarios){
                    totalVoluntarios++;
                }
                System.out.println("Voluntários Ativos: " + totalVoluntarios);

                for(Veterinario u : veterinarios){
                    totalVeterinarios++;
                }
                System.out.println("Veterinarios Ativos: " + totalVeterinarios);
                
                System.out.println();
                System.out.println("Taxa de adoção: " + taxa + "%");
                break;
                
            case 7:
                TelaPrincipal.telaCriarAtividade(AtividadeService);
                break;
            case 0:
                rodando = false;
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida no menu principal!");
                break;
        }
    } catch (InputMismatchException e) {
        System.out.println("Erro! Digite um número válido no menu principal.");
        scanner.next(); 
    }
}
}
    @Override
    public String getTipoUsuario() {
        throw new UnsupportedOperationException("Unimplemented method 'getTipoUsuario'");
    }
}
