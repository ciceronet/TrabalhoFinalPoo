package modelo;
import exceptions.*;
import service.AtividadeService;
import ui.TelaPrincipal;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Voluntario extends Usuario{
    public Voluntario (String email, String nome, String senha) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        super(email, nome, senha);
    }
    Scanner scanner = new Scanner(System.in);
    List<Atividade> participacao = new ArrayList<>();
    @Override 
    public void Menu(AtividadeService atividadeService) {
        int resposta;
        boolean rodando = true;
        while(rodando) {
            System.out.println("1 - Visualizar animais disponíveis para adoção");
            System.out.println("2 - Candidatar-se para atividade de apoio");
            System.out.println("3 - Animais sob sua responsabilidade");
            System.out.println("4 - Histórico de participações em ONG");
            System.out.println("0 - Sair");
            System.out.println("Selecione a opção desejada!");
            try {
                resposta = scanner.nextInt();
                switch (resposta) {
                    case 1:
                        rodando = false;
                        break;
                    case 2:
                        TelaPrincipal.telaInscricao(atividadeService, this);
                        rodando = false;
                        break;
                    case 0:
                        rodando = false;
                        break;
                    default:
                        System.out.println("Selecione apenas uma das opções acima");
                        break;
                }
            } catch( NumberFormatException e) {
                System.out.println("Erro! Digite um número!");
            }
    }
}
    public void registrarParticipacao(Atividade atividade) {
        try {
        if(atividade == null) {
            throw new AtividadeException(" Atividade inválida!");
        }
        participacao.add(atividade);
        } catch(AtividadeException e) {
            System.out.println("Erro!" + e.getMessage());
        }
    }
    public List<Atividade> getParticipacoes() {
        return new ArrayList<>(participacao);
    }
}