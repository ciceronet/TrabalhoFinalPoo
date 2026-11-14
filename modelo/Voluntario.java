package modelo;

import java.util.ArrayList;
import java.util.List;
import exceptions.*;
import service.Contexto;
import ui.Entrada;
import ui.TelaPrincipal;

public class Voluntario extends Usuario {
    private final List<Animais> animaisResponsaveis = new ArrayList<>();
    private final List<Atividade> participacao = new ArrayList<>();

    public Voluntario(String email, String nome, String senha) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        super(email, nome, senha);
    }

    @Override
    public void Menu(Contexto ctx) {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n      MENU DO VOLUNTÁRIO      ");
            System.out.println("1 - Visualizar animais disponíveis para adoção");
            System.out.println("2 - Candidatar-se para atividade de apoio");
            System.out.println("3 - Animais sob sua responsabilidade");
            System.out.println("4 - Histórico de participações em ONG");
            System.out.println("5 - Solicitar adoção");
            System.out.println("6 - Buscar e filtrar animais");
            System.out.println("7 - Notificações");
            System.out.println("0 - Sair");
            System.out.print("Selecione a opção desejada: ");
            switch (Entrada.lerInt()) {
                case 1:
                    listarDisponiveis(ctx);
                    break;
                case 2:
                    TelaPrincipal.telaInscricao(ctx.atividadeService, this);
                    break;
                case 3:
                    if (animaisResponsaveis.isEmpty()) {
                        System.out.println("Você não tem animais sob sua responsabilidade.");
                    }
                    for (Animais a : animaisResponsaveis) {
                        System.out.println(a);
                    }
                    break;
                case 4:
                    TelaPrincipal.telaHistorico(this);
                    break;
                case 5:
                    solicitarAdocao(ctx);
                    break;
                case 6:
                    Animais.filtroAnimais(ctx.cadastrados);
                    break;
                case 7:
                    if (ctx.notificacoes.isEmpty()) {
                        System.out.println("Nenhuma notificação.");
                    }
                    for (Notificacao n : ctx.notificacoes) {
                        System.out.println(n);
                    }
                    break;
                case 0:
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void listarDisponiveis(Contexto ctx) {
        System.out.println("\n      ANIMAIS DISPONÍVEIS      ");
        boolean achou = false;
        for (Animais a : ctx.cadastrados) {
            if (a.podeSerAdotado()) {
                System.out.println(a);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum animal disponível no momento.");
        }
    }

    private void solicitarAdocao(Contexto ctx) {
        System.out.println("\n      SOLICITAR ADOÇÃO      ");
        System.out.print("Digite o ID do animal: ");
        int id = Entrada.lerInt();
        Animais encontrado = null;
        for (Animais a : ctx.cadastrados) {
            if (a.getId() == id) {
                encontrado = a;
                break;
            }
        }
        if (encontrado == null) {
            System.out.println("Animal não encontrado!");
            return;
        }
        try {
            if (!encontrado.getStatus().equalsIgnoreCase(Animais.DISPONIVEL)) {
                throw new AnimalIndisponivelException("Erro! Este animal não está disponível para adoção!");
            }
            if (encontrado.getEstadoSaude().equalsIgnoreCase(Animais.CRITICO)) {
                throw new AnimalIndisponivelException("Erro! Animal em estado crítico não pode ser adotado!");
            }
            for (SolicitacaoAdocao s : ctx.solicitacoes) {
                if (s.getAnimal().getId() == id && s.getVoluntario() == this
                        && s.getStatus().equalsIgnoreCase("PENDENTE")) {
                    throw new AnimalIndisponivelException("Erro! Você já tem uma solicitação pendente para este animal!");
                }
            }
            SolicitacaoAdocao nova = new SolicitacaoAdocao(this, encontrado);
            ctx.solicitacoes.add(nova);
            System.out.println("Solicitação realizada! ID: " + nova.getId() + ". Aguardando aprovação do administrador.");
        } catch (AnimalIndisponivelException e) {
            System.out.println(e.getMessage());
        }
    }

    public void assumirResponsabilidade(Animais animal) {
        animaisResponsaveis.add(animal);
    }

    public void liberarResponsabilidade(Animais animal) {
        animaisResponsaveis.remove(animal);
    }
    
    public void registrarParticipacao(Atividade atividade) throws AtividadeException {
        if (atividade == null) {
            throw new AtividadeException("Erro! Atividade inválida!");
        }
        participacao.add(atividade);
    }

    public List<Atividade> getParticipacoes() {
        return new ArrayList<>(participacao);
    }

    @Override
    public String getTipoUsuario() {
        return "Voluntário";
    }
}
