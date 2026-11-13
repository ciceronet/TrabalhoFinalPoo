package modelo;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.*;
public class Voluntario extends Usuario{
    
    public Voluntario (String email, String nome, String senha,int animalResponsavel) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        super(email, nome, senha);
    }
    ArrayList<Animais> animiasResponsaveis=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    int resposta;
    @Override 
    public void Menu(ArrayList<Animais> cadastrados,ArrayList<Animais> adotados,ArrayList<Animais> tratando,ArrayList<Voluntario> voluntarios, ArrayList<Veterinario> veterinarios,ArrayList<Atividade> eventos, ArrayList<Notificacao> notifica,ArrayList<SolicitacaoAdocao>solicitacoes,Scanner sc) {
        
        boolean rodando = true;
        while(rodando) {
            System.out.println("1 - Visualizar animais disponíveis para adoção");
            System.out.println("2 - Candidatar-se para atividade de apoio");
            System.out.println("3 - Animais sob sua responsabilidade");
            System.out.println("4 - Histórico de participações em ONG");
            System.out.println("5 - Solicitar adoção");
            switch (resposta) {
                case 1:              
                System.out.println("\n===== ANIMAIS DISPONÍVEIS =====");
                 for (Animais u : cadastrados) {

                if (u.getStatus().equalsIgnoreCase("Disponível")) {

                    System.out.println("--------------------------");
                    System.out.println("ID: " + u.getId());
                    System.out.println("Nome: " + u.getNome());
                    System.out.println("Espécie: " + u.getEspecie());
                    System.out.println("Raça: " + u.getRaca());
                    System.out.println("Idade: " + u.getIdade());
                    System.out.println("Estado de saúde: " + u.getEstadoSaude());

                     }

                }
                    break;
                case 2:
                    
                    break;
                case 3:
                    for(Animais u:animiasResponsaveis){
                        System.out.println("--------------------------");
                    System.out.println("ID: " + u.getId());
                    System.out.println("Nome: " + u.getNome());
                    System.out.println("Espécie: " + u.getEspecie());
                    System.out.println("Raça: " + u.getRaca());
                    System.out.println("Idade: " + u.getIdade());
                    System.out.println("Estado de saúde: " + u.getEstadoSaude());
                    System.out.println("\n");
                }
                    break;
                case 4:
                
                    break;
                case 5:
                    System.out.println("\n===== SOLICITAR ADOÇÃO =====");

    System.out.print("Digite o ID do animal: ");
    int id = sc.nextInt();
    sc.nextLine();

    Animais animalEncontrado = null;

    for (Animais u : cadastrados) {

        if (u.getId() == id) {
            animalEncontrado = u;
            break;
        }

    }

    if (animalEncontrado == null) {
        System.out.println("Animal não encontrado!");
        return;
    }

    try {

        if (!animalEncontrado.getStatus().equalsIgnoreCase("Disponível")) {
            throw new IllegalStateException("Este animal não está disponível para adoção!");
        }

        if (animalEncontrado.getEstadoSaude().equalsIgnoreCase("Crítico")) {
            throw new IllegalStateException("Animal em estado crítico não pode ser adotado!");
        }

        for (SolicitacaoAdocao u : solicitacoes) {

            if (u.getAnimal().getId() == id &&
                    u.getStatus().equalsIgnoreCase("PENDENTE")) {

                throw new IllegalStateException("Já existe uma solicitação pendente para este animal!");

            }

        }

        SolicitacaoAdocao novaSolicitacao = new SolicitacaoAdocao(this, animalEncontrado);

        solicitacoes.add(novaSolicitacao);

        System.out.println("Solicitação realizada com sucesso!");
        System.out.println("ID da solicitação: " + novaSolicitacao.getId());
        System.out.println("Aguardando aprovação do administrador.");

    } catch (IllegalStateException e) {

        System.out.println("Erro: " + e.getMessage());

    }
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    public void registrarParticipacao(Atividade atividade) {
        throw new UnsupportedOperationException("Unimplemented method 'registrarParticipacao'");
    }
    @Override
    public String getTipoUsuario() {
        throw new UnsupportedOperationException("Unimplemented method 'getTipoUsuario'");
    }
}