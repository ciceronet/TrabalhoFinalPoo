package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import exceptions.*;
import service.Contexto;
import service.Validacao;
import ui.Entrada;
import ui.Selecao;
import ui.TelaPrincipal;

public class Veterinario extends Usuario {

    public Veterinario(String email, String nome, String senha) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        super(email, nome, senha);
    }

    @Override
    public void Menu(Contexto ctx) {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n      MENU DO VETERINÁRIO      ");
            System.out.println("1 - Registrar consulta");
            System.out.println("2 - Registrar tratamento");
            System.out.println("3 - Atualizar estado de saúde");
            System.out.println("4 - Gerenciar vacinas");
            System.out.println("5 - Gerenciar medicamentos");
            System.out.println("6 - Emitir relatório de saúde");
            System.out.println("0 - Sair");
            System.out.print("Selecione a opção que deseja: ");
            int opcao = Entrada.lerInt();
            if (opcao == 0) {
                rodando = false;
                continue;
            }
            if (opcao < 1 || opcao > 6) {
                System.out.println("Opção inválida!");
                continue;
            }
            Animais animal = escolherAnimal(ctx);
            if (animal == null) {
                continue;
            }
            try {
                switch (opcao) {
                    case 1: registrarConsulta(ctx, animal); break;
                    case 2: registrarTratamento(ctx, animal); break;
                    case 3: atualizarSaude(animal); break;
                    case 4: gerenciarVacinas(ctx, animal); break;
                    case 5: gerenciarMedicamentos(ctx, animal); break;
                    default: System.out.println(ctx.controleSaude.gerarRelatorio(animal));
                }
            } catch (ConsultaDuplicadaException | VacinaDuplicadaException | MedicamentoDuplicadoException | TratamentoDuplicadoException | NomeInvalidoException | AtividadeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Animais escolherAnimal(Contexto ctx) {
        ArrayList<Animais> todos = new ArrayList<>(ctx.cadastrados);
        todos.addAll(ctx.adotados);
        if (todos.isEmpty()) {
            System.out.println("Não existem animais cadastrados!");
            return null;
        }
        for (int i = 0; i < todos.size(); i++) {
            System.out.println((i + 1) + " - " + todos.get(i).getNome() + " (" + todos.get(i).getEspecie() + ")");
        }
        System.out.print("Escolha o animal: ");
        int n = Entrada.lerInt();
        if (n < 1 || n > todos.size()) {
            System.out.println("Opção inválida!");
            return null;
        }
        return todos.get(n - 1);
    }

    private void registrarConsulta(Contexto ctx, Animais animal) throws NomeInvalidoException, AtividadeException, ConsultaDuplicadaException {
        System.out.print("Descrição da consulta: ");
        String descricao = Entrada.lerLinha();
        Validacao.validarDescricao(descricao);
        LocalDate data = TelaPrincipal.lerData("Data da consulta");
        Validacao.validarDataResgate(data);
        ctx.controleSaude.registrarConsulta(animal, new Consulta(data, descricao));
        System.out.println("Consulta registrada com sucesso!");
    }

    private void registrarTratamento(Contexto ctx, Animais animal) throws NomeInvalidoException, TratamentoDuplicadoException {
        System.out.print("Descrição do tratamento: ");
        String descricao = Entrada.lerLinha();
        Validacao.validarDescricao(descricao);
        ctx.controleSaude.registrarTratamento(animal, new Tratamento(descricao));
        System.out.println("Tratamento registrado com sucesso!");
    }

    private void atualizarSaude(Animais animal) {
        animal.setEstadoSaude(Selecao.selecionarSaude());
        System.out.println("Estado de saúde atualizado para: " + animal.getEstadoSaude());
        if (animal.getEstadoSaude().equalsIgnoreCase(Animais.CRITICO)) {
            System.out.println("Atenção: animal em estado crítico não pode ser adotado.");
        }
    }

    private void gerenciarVacinas(Contexto ctx, Animais animal) throws NomeInvalidoException, VacinaDuplicadaException {
        System.out.println("1 - Adicionar vacina");
        System.out.println("2 - Remover vacina");
        System.out.print("Escolha: ");
        int opcao = Entrada.lerInt();
        if (opcao == 1) {
            System.out.print("Nome da vacina: ");
            String nome = Entrada.lerLinha();
            Validacao.validarDescricao(nome);
            ctx.controleSaude.registrarVacina(animal, new Vacina(nome));
            System.out.println("Vacina registrada com sucesso!");
        } else if (opcao == 2) {
            ArrayList<Vacina> vacinas = animal.getHistoricoMedico().getVacinas();
            if (vacinas.isEmpty()) {
                System.out.println("Não existem vacinas registradas!");
                return;
            }
            for (int i = 0; i < vacinas.size(); i++) {
                System.out.println((i + 1) + " - " + vacinas.get(i).gerarRelatorio());
            }
            System.out.print("Escolha a vacina que deseja remover: ");
            removerSeguro(() -> ctx.controleSaude.removerVacina(animal, Entrada.lerInt() - 1), "Vacina removida com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private void gerenciarMedicamentos(Contexto ctx, Animais animal) throws NomeInvalidoException, MedicamentoDuplicadoException {
        System.out.println("1 - Adicionar medicamento");
        System.out.println("2 - Remover medicamento");
        System.out.print("Escolha: ");
        int opcao = Entrada.lerInt();
        if (opcao == 1) {
            System.out.print("Nome do medicamento: ");
            String nome = Entrada.lerLinha();
            Validacao.validarDescricao(nome);
            ctx.controleSaude.registrarMedicamento(animal, new Medicamento(nome));
            System.out.println("Medicamento registrado com sucesso!");
        } else if (opcao == 2) {
            ArrayList<Medicamento> medicamentos = animal.getHistoricoMedico().getMedicamentos();
            if (medicamentos.isEmpty()) {
                System.out.println("Não existem medicamentos registrados!");
                return;
            }
            for (int i = 0; i < medicamentos.size(); i++) {
                System.out.println((i + 1) + " - " + medicamentos.get(i).gerarRelatorio());
            }
            System.out.print("Escolha o medicamento que deseja remover: ");
            removerSeguro(() -> ctx.controleSaude.removerMedicamento(animal, Entrada.lerInt() - 1), "Medicamento removido com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private void removerSeguro(Runnable acao, String sucesso) {
        try {
            acao.run();
            System.out.println(sucesso);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getTipoUsuario() {
        return "Veterinário";
    }
}
