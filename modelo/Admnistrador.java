package modelo;

import java.util.ArrayList;
import exceptions.*;
import service.Contexto;
import ui.Entrada;
import ui.TelaPrincipal;

public class Admnistrador extends Usuario {

    public Admnistrador(String email, String nome, String senha) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        super(email, nome, senha);
    }

    @Override
    public void Menu(Contexto ctx) {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n      MENU DO ADMINISTRADOR      ");
            System.out.println("1 - Cadastrar animal");
            System.out.println("2 - Gerenciar animal (editar/excluir)");
            System.out.println("3 - Buscar e filtrar animais");
            System.out.println("4 - Solicitações de adoção");
            System.out.println("5 - Gerenciar usuários");
            System.out.println("6 - Notificações");
            System.out.println("7 - Relatórios");
            System.out.println("8 - Estatísticas");
            System.out.println("9 - Cadastrar atividade");
            System.out.println("0 - Sair");
            System.out.print("Selecione a opção desejada: ");
            switch (Entrada.lerInt()) {
                case 1:
                    int antes = ctx.cadastrados.size();
                    Animais.cadastrarAnimal(ctx.cadastrados, ctx.sc);
                    if (ctx.cadastrados.size() > antes) {
                        ctx.notificacoes.add(new Notificacao("Novo animal cadastrado: " + ctx.cadastrados.get(ctx.cadastrados.size() - 1).getNome()));
                    }
                    break;
                case 2:
                    Animais.gerenciarAnimal(ctx.cadastrados, ctx.sc);
                    break;
                case 3:
                    ArrayList<Animais> todos = new ArrayList<>(ctx.cadastrados);
                    todos.addAll(ctx.adotados);
                    Animais.filtroAnimais(todos);
                    break;
                case 4:
                    menuAdocao(ctx);
                    break;
                case 5:
                    gerenciarUsuarios(ctx);
                    break;
                case 6:
                    notificacoes(ctx);
                    break;
                case 7:
                    relatorios(ctx);
                    break;
                case 8:
                    estatisticas(ctx);
                    break;
                case 9:
                    TelaPrincipal.telaCriarAtividade(ctx);
                    break;
                case 0:
                    rodando = false;
                    System.out.println("Saindo do menu do administrador.");
                    break;
                default:
                    System.out.println("Opção inválida no menu principal!");
            }
        }
    }

    private void menuAdocao(Contexto ctx) {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n      PROCESSO DE ADOÇÃO      ");
            System.out.println("1 - Analisar solicitações pendentes");
            System.out.println("2 - Registrar devolução");
            System.out.println("3 - Histórico de adoções");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            switch (Entrada.lerInt()) {
                case 1: 
                analisarSolicitacoes(ctx); 
                    break;
                case 2: 
                registrarDevolucao(ctx); 
                    break;
                case 3: 
                historicoAdocoes(ctx); 
                    break;
                case 0: 
                voltar = true; 
                    break;
                default: 
                System.out.println("Opção inválida!");
            }
        }
    }

    private void analisarSolicitacoes(Contexto ctx){
        boolean encontrou = false;
        for (SolicitacaoAdocao s : ctx.solicitacoes) {
            if (s.getStatus().equalsIgnoreCase("PENDENTE")){
                encontrou = true;
                System.out.println("--------------------------");
                System.out.println("ID da solicitação: " + s.getId());
                System.out.println("Voluntário: " + s.getVoluntario().getNome());
                System.out.println("Animal: " + s.getAnimal().getNome() + " (ID " + s.getAnimal().getId() + ")");
            }
        }
        if (!encontrou){
            System.out.println("Não existem solicitações pendentes.");
            return;
        }
        System.out.print("Digite o ID da solicitação (0 para voltar): ");
        int id = Entrada.lerInt();
        SolicitacaoAdocao escolhida = null;
        for (SolicitacaoAdocao s : ctx.solicitacoes) {
            if (s.getId() == id && s.getStatus().equalsIgnoreCase("PENDENTE")){
                escolhida = s;
            }
        }
        if (escolhida == null){
            if (id != 0){
                System.out.println("Solicitação não encontrada!");
            }
            return;
        }
        System.out.println("1 - Aprovar adoção");
        System.out.println("2 - Rejeitar adoção");
        System.out.print("Escolha: ");
        int decisao = Entrada.lerInt();
        if (decisao == 1){
            aprovar(ctx, escolhida);
        } else if (decisao == 2) {
            escolhida.setStatus("RECUSADA");
            ctx.notificacoes.add(new Notificacao("Solicitação de adoção de " + escolhida.getAnimal().getNome() + " foi rejeitada."));
            System.out.println("Solicitação recusada!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private void aprovar(Contexto ctx, SolicitacaoAdocao s){
        Animais animal = s.getAnimal();
        if (!animal.podeSerAdotado()){
            System.out.println("Erro! O animal não pode ser adotado (indisponível ou em estado crítico).");
            return;
        }
        animal.setStatus(Animais.ADOTADO);
        ctx.cadastrados.remove(animal);
        ctx.adotados.add(animal);
        s.setStatus("APROVADA");
        s.getVoluntario().assumirResponsabilidade(animal);
        for (SolicitacaoAdocao outra : ctx.solicitacoes) {
            if (outra != s && outra.getAnimal() == animal && outra.getStatus().equalsIgnoreCase("PENDENTE")){
                outra.setStatus("RECUSADA");
            }
        }
        ctx.notificacoes.add(new Notificacao("Adoção aprovada: " + animal.getNome()));
        System.out.println("Adoção aprovada com sucesso!");
    }

    private void registrarDevolucao(Contexto ctx){
        if (ctx.adotados.isEmpty()) {
            System.out.println("Não há animais adotados.");
            return;
        }
        for (Animais a : ctx.adotados){
            System.out.println(a);
        }
        System.out.print("Digite o ID do animal devolvido: ");
        int id = Entrada.lerInt();
        for (Animais a : new ArrayList<>(ctx.adotados)){
            if (a.getId() == id){
                a.setStatus(Animais.DISPONIVEL);
                ctx.adotados.remove(a);
                ctx.cadastrados.add(a);
                for (SolicitacaoAdocao s : ctx.solicitacoes){
                    if (s.getAnimal() == a && s.getStatus().equalsIgnoreCase("APROVADA")){
                        s.setStatus("DEVOLVIDA");
                        s.getVoluntario().liberarResponsabilidade(a);
                    }
                }
                ctx.notificacoes.add(new Notificacao("Animal devolvido e disponível novamente: " + a.getNome()));
                System.out.println("Devolução registrada!");
                return;
            }
        }
        System.out.println("Animal não encontrado entre os adotados.");
    }

    private void historicoAdocoes(Contexto ctx){
        if (ctx.solicitacoes.isEmpty()) {
            System.out.println("Nenhuma solicitação registrada.");
        }
        for (SolicitacaoAdocao s : ctx.solicitacoes){
            System.out.println("#" + s.getId() + " | " + s.getAnimal().getNome() + " | " + s.getVoluntario().getNome() + " | " + s.getStatus());
        }
    }

    private void gerenciarUsuarios(Contexto ctx){
        for (int i = 0; i < ctx.usuarios.size(); i++){
            Usuario u = ctx.usuarios.get(i);
            System.out.println((i + 1) + " - " + u.getNome() + " | " + u.getEmail() + " | " + u.getTipoUsuario());
        }
        System.out.print("Número do usuário a remover (0 para voltar): ");
        int n = Entrada.lerInt();
        if (n < 1 || n > ctx.usuarios.size()){
            return;
        }
        Usuario alvo = ctx.usuarios.get(n - 1);
        if (alvo == this) {
            System.out.println("Você não pode remover a si mesmo.");
            return;
        }
        ctx.usuarios.remove(alvo);
        ctx.voluntarios.remove(alvo);
        ctx.veterinarios.remove(alvo);
        System.out.println("Usuário removido.");
    }

    private void notificacoes(Contexto ctx){
        if (ctx.notificacoes.isEmpty()){
            System.out.println("Nenhuma notificação.");
        }
        for (Notificacao n : ctx.notificacoes){
            System.out.println(n);
        }
        System.out.print("Digite um aviso geral para os usuários (Enter para pular): ");
        String aviso = Entrada.lerLinha();
        if (!aviso.isBlank()) {
            ctx.notificacoes.add(new Notificacao("Aviso do abrigo: " + aviso));
            System.out.println("Aviso publicado.");
        }
    }

    private ArrayList<Animais> todosAnimais(Contexto ctx){
        ArrayList<Animais> todos = new ArrayList<>(ctx.cadastrados);
        todos.addAll(ctx.adotados);
        return todos;
    }

    private ArrayList<Animais> emTratamento(Contexto ctx){
        ArrayList<Animais> lista = new ArrayList<>();
        for (Animais a : ctx.cadastrados) {
            if (!a.getEstadoSaude().equalsIgnoreCase("Saudável")){
                lista.add(a);
            }
        }
        return lista;
    }

    private void relatorios(Contexto ctx){
        System.out.println("1 - Animais resgatados");
        System.out.println("2 - Adoções realizadas");
        System.out.println("3 - Animais em tratamento");
        System.out.println("4 - Voluntários ativos");
        System.out.println("5 - Atividades realizadas");
        System.out.println("6 - Espécies mais resgatadas");
        System.out.print("Selecione a sub-opção: ");
        switch (Entrada.lerInt()){
            case 1:
            imprimir(todosAnimais(ctx)); 
                break;
            case 2: 
            imprimir(ctx.adotados); 
                break;
            case 3: 
            imprimir(emTratamento(ctx)); 
                break;
            case 4:
                for (Voluntario v : ctx.voluntarios) {
                    System.out.println(v.getNome() + " | " + v.getEmail()
                            + " | participações: " + v.getParticipacoes().size());
                }
                break;
            case 5: 
            TelaPrincipal.atividadesRealizadas(ctx.atividadeService); 
                break;
            case 6:
                int caes = 0, gatos = 0;
                for (Animais a : todosAnimais(ctx)) {
                    if (a.getEspecie().equalsIgnoreCase("Cachorro")) caes++; else gatos++;
                }
                System.out.println("Cachorros: " + caes + " | Gatos: " + gatos);
                break;
            default: System.out.println("Opção de relatório inválida!");
        }
    }

    private void imprimir(ArrayList<Animais> lista) {
        if (lista.isEmpty()) {
            System.out.println("Nenhum registro.");
        }
        for (Animais a : lista) {
            System.out.println(a);
        }
    }

    private void estatisticas(Contexto ctx) {
        int total = ctx.cadastrados.size() + ctx.adotados.size();
        int taxa = total == 0 ? 0 : (ctx.adotados.size() * 100) / total;
        System.out.println("Animais resgatados (total): " + total);
        System.out.println("Disponíveis/abrigados: " + ctx.cadastrados.size());
        System.out.println("Adotados: " + ctx.adotados.size());
        System.out.println("Em tratamento: " + emTratamento(ctx).size());
        System.out.println("Voluntários ativos: " + ctx.voluntarios.size());
        System.out.println("Veterinários ativos: " + ctx.veterinarios.size());
        System.out.println("Taxa de adoção: " + taxa + "%");
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }
}
