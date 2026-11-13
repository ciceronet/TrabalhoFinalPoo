package modelo;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.*;

public class Admnistrador extends Usuario{
      public Admnistrador(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
    int contador=0;
    Scanner scanner = new Scanner(System.in);
    @SuppressWarnings("unused")
    @Override 
    public void Menu(ArrayList<Animais> cadastrados , ArrayList<Animais> adotados , ArrayList<Animais> tratando ,ArrayList<Voluntario> voluntarios , ArrayList<Veterinario> veterinario,ArrayList<Atividade> eventos,ArrayList<Notificacao>notifica,ArrayList<SolicitacaoAdocao>solicitacoes,Scanner sc) {   
        boolean rodando = true;
        int resposta;
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Gerenciar animal");
        System.out.println("3 - Solicitações de adoção");
        System.out.println("4 - Gerenciar Usuarios");
        System.out.println("5 - Notificações");
        System.out.println("6 - relatórios");
        System.out.println("7 - Estatisticas");
        while(rodando) {
            System.out.println("Selecione a opção desejada");
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                Animais.cadastrarAnimal(cadastrados, scanner);
                    break;
                case 2:
                Animais.gerenciarAnimal(cadastrados,scanner);
                    break;
                case 3:
                while (rodando) {

        System.out.println("\n===== SOLICITAÇÕES DE ADOÇÃO =====");

        boolean encontrou = false;

        for (SolicitacaoAdocao u : solicitacoes) {

            if (u.getStatus().equalsIgnoreCase("PENDENTE")) {

                encontrou = true;

                System.out.println("--------------------------");
                System.out.println("ID da solicitação: " + u.getId());
                System.out.println("Voluntário: " + u.getVoluntario().getNome());
                System.out.println("Animal: " + u.getAnimal().getNome());
                System.out.println("ID do animal: " + u.getAnimal().getId());
                System.out.println("Status: " + u.getStatus());

            }

        }

        if (!encontrou) {
            System.out.println("Não existem solicitações pendentes.");
            return;
        }

        System.out.println("\n1 - Analisar solicitação");
        System.out.println("0 - Voltar");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {

            case 1:

                System.out.print("Digite o ID da solicitação: ");
                int id = sc.nextInt();
                sc.nextLine();

                SolicitacaoAdocao solicitacaoEncontrada = null;

                for (SolicitacaoAdocao u : solicitacoes) {

                    if (u.getId() == id &&
                            u.getStatus().equalsIgnoreCase("PENDENTE")) {

                        solicitacaoEncontrada = u;
                        break;

                    }

                }

                if (solicitacaoEncontrada == null) {
                    System.out.println("Solicitação não encontrada!");
                    break;
                }

                System.out.println("\n===== ANALISAR SOLICITAÇÃO =====");
                System.out.println("Voluntário: " + solicitacaoEncontrada.getVoluntario().getNome());
                System.out.println("Animal: " + solicitacaoEncontrada.getAnimal().getNome());

                System.out.println("\n1 - Aprovar adoção");
                System.out.println("2 - Recusar adoção");
                int decisao = sc.nextInt();
                sc.nextLine();
                switch (decisao) {
                    case 1:
                        Animais animal = solicitacaoEncontrada.getAnimal();
                        animal.setStatus("Adotado");
                        cadastrados.remove(animal);
                        adotados.add(animal);
                        solicitacaoEncontrada.setStatus("APROVADA");
                        for (SolicitacaoAdocao u : solicitacoes) {

                            if (u.getAnimal().getId() == animal.getId()
                                    && u.getStatus().equalsIgnoreCase("PENDENTE")) {
                                u.setStatus("RECUSADA");

                            }

                        }
                        System.out.println("Adoção aprovada com sucesso!");
                        break;
                    case 2:
                        solicitacaoEncontrada.setStatus("RECUSADA");
                        System.out.println("Solicitação recusada!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                break;
            case 0:
                rodando = false;
                break;
            default:
                System.out.println("Opção inválida!");

        }

    }
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                int opcao=scanner.nextInt();
                System.out.println("1 - Animias Resgatados");
                System.out.println("2 - Adoçoes realizadas");
                System.out.println("3 - Animais em tratamento");
                System.out.println("4 - Voluntarios Ativos");
                System.out.println("5 - Eventos Realizados");
                switch (opcao) {
                    case 1:
                    for (Animais u : cadastrados) {
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
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
                        break;
                }
                    break;
                case 7:
                    int contador=0;
                    int taxa = 0;
                for(Animais u : cadastrados){
                    contador++;
                }
                System.out.println("Animais cadastrados:"+contador);
                for(Animais u:adotados){
                    taxa++;
                }
                taxa=(taxa*100)/contador;
                System.out.println("Animais adotados:"+contador);
                contador=0;
                for(Animais u:tratando){
                    contador++;
                }
                System.out.println("Animais em tratamento:"+contador);
                contador=0;
                for(Voluntario u:voluntarios){
                    contador++;
                }
                System.out.println("Animais em tratamento:"+contador);
                contador=0;
                for(Voluntario u:voluntarios){
                    contador++;
                }
                System.out.println("Voluntários Ativos:"+contador);
                contador=0;
                for(Veterinario u:veterinario){
                    contador++;
                }
                System.out.println("Veterinarios Ativos:"+contador);
                System.out.println("");
                System.out.println("Taxa de adoção:"+taxa);
                    break;
                default:
                    break;
            }
        }

    }
    @Override
    public String getTipoUsuario() {
        throw new UnsupportedOperationException("Unimplemented method 'getTipoUsuario'");
    }
}
