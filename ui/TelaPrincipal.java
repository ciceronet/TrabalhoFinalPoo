package ui;

import service.Validacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import enums.TipoAtividade;
import exceptions.AtividadeException;
import modelo.Atividade;
import modelo.Notificacao;
import modelo.Voluntario;
import service.AtividadeService;
import service.Contexto;

public class TelaPrincipal {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private TelaPrincipal() {
    }

    public static LocalDate lerData(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (dd/mm/aaaa): ");
            String entrada = Entrada.lerLinha();
            try {
                return LocalDate.parse(entrada, FORMATO_DATA);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida! Use o formato dd/mm/aaaa.");
            }
        }
    }

    public static void telaCriarAtividade(Contexto ctx){
        System.out.println("\n      CADASTRAR ATIVIDADE      ");
        try {
            System.out.print("Número de vagas: ");
            int vagas = Entrada.lerInt();
            Validacao.validarVagas(vagas);
            LocalDate data = lerData("Data da atividade");
            TipoAtividade tipo = Selecao.selecionarAtividade();
            Atividade a = ctx.atividadeService.criarAtividade(vagas, data, tipo);
            ctx.notificacoes.add(new Notificacao("Nova atividade: " + a.getTipo().getDescricao()+ " em " + a.getData().format(FORMATO_DATA)));
            System.out.println("Atividade criada com sucesso!");
        } catch (AtividadeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Atividade> atividadesDisponiveis(AtividadeService servico){
        List<Atividade> abertas = servico.atividadesAbertas();
        if (abertas.isEmpty()){
            System.out.println("Não há atividades abertas no momento.");
            return abertas;
        }
        System.out.println("Atividades abertas:");
        for (int i = 0; i < abertas.size(); i++){
            Atividade a = abertas.get(i);
            System.out.println((i + 1) + " - " + a.getTipo().getDescricao()+ " | Data: " + a.getData().format(FORMATO_DATA)+ " | Vagas restantes: " + a.getVagasRestantes());
        }
        return abertas;
    }

    public static void telaInscricao(AtividadeService servico, Voluntario voluntario){
        List<Atividade> abertas = atividadesDisponiveis(servico);
        if (abertas.isEmpty()){
            return;
        }
        System.out.println("0 - Voltar");
        System.out.print("Selecione a atividade desejada: ");
        int escolha = Entrada.lerInt();
        if (escolha == 0){
            return;
        }
        if (escolha < 1 || escolha > abertas.size()){
            System.out.println("Opção inválida!");
            return;
        }
        try {
            servico.inscrever(abertas.get(escolha - 1), voluntario);
            System.out.println("Inscrição realizada com sucesso!");
        } catch (AtividadeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void telaHistorico(Voluntario voluntario){
        List<Atividade> participacoes = voluntario.getParticipacoes();
        if (participacoes.isEmpty()){
            System.out.println("Você ainda não participou de nenhuma atividade.");
            return;
        }
        System.out.println("Seu histórico de participações:");
        for (Atividade a : participacoes){
            System.out.println("- " + a.getTipo().getDescricao() + " | " + a.getData().format(FORMATO_DATA));
        }
    }

    public static void atividadesRealizadas(AtividadeService servico){
        List<Atividade> realizadas = servico.atividadesRealizadas();
        if (realizadas.isEmpty()){
            System.out.println("Nenhuma atividade foi concluída ainda.");
            return;
        }
        System.out.println("Atividades realizadas:");
        for (Atividade a : realizadas){
            System.out.println("- " + a.getTipo().getDescricao() + " | " + a.getData().format(FORMATO_DATA)+ " | Participantes: " + a.getVoluntarios().size());
        }
    }
}
