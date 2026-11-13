package modelo;
import exceptions.*;
import java.util.Scanner;
import service.Validacao;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.DateTimeException;
public class Veterinario extends Usuario {
    Scanner scan = new Scanner(System.in);
    public Veterinario(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
    @Override 
    public void Menu(Animal animal, AtividadeService atividadeService, ControleSaude controleSaude, ArrayList<Animais> cadastrados) {
        boolean rodando = true;
        int resposta;
        while (rodando) {
            System.out.println("\n         MENU         \n");
            System.out.println("1 - Registrar consultas e tratamentos");
            System.out.println("2 - Atualizar informações médicas dos animais");
            System.out.println("3 - Emitir relatórios de saúde dos animais");
            System.out.println("Selecione a opção que deseja");
            resposta = scan.nextInt();
            switch (resposta) {
            case 1:
                boolean rodando1 = true;
                while (rodando1) {
                System.out.println("          Consultas e Registros      ");
                System.out.println("1 - Registrar consulta");
                System.out.println("2 - Registrar tratamento");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
                int opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        try {
                            if (cadastrados.isEmpty()) {
                                System.out.println("Não existem animais cadastrados!");
                                break;;
                            }
                            for (int i = 0; i < cadastrados.size(); i++) {
                                System.out.println((i + 1) + " - " + cadastrados.get(i).getNome());
                            }
                            System.out.print("Escolha o animal: ");
                            int opcao1 = scan.nextInt();
                            scan.nextLine();
                            if (opcao1 < 1 || opcao1 > cadastrados.size()) {
                            System.out.println("Opção inválida!");
                            break;
                            }
                            Animais animall = cadastrados.get(opcao1 - 1);
                            System.out.println("Digite a descricao");
                            String descricao = scan.nextLine();
                            Validacao.validarNome(descricao);
                            System.out.print("Digite a data da consulta (AAAA-MM-DD): ");
                            LocalDate data = LocalDate.parse(scan.nextLine());
                            Validacao.validarDataResgate(data);
                            Consulta consulta = new Consulta(data, descricao);
                            controleSaude.registrarConsulta(animall, consulta);
                            System.out.println("Consulta registrada com sucesso!");
                        } catch (NomeInvalidoException e) {
                            System.out.println(e.getMessage());
                        } catch (DateTimeParseException e) {
                            System.out.println(e.getMessage());
                        } catch (ConsultaDuplicadaException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            if (cadastrados.isEmpty()) {
                                System.out.println("Não existem animais cadastrados!");
                                break;;
                            }
                            for (int i = 0; i < cadastrados.size(); i++) {
                                System.out.println((i + 1) + " - " + cadastrados.get(i).getNome());
                            }
                            System.out.print("Escolha o animal: ");
                            int opcao1 = scan.nextInt();
                            scan.nextLine();
                            if (opcao1 < 1 || opcao1 > cadastrados.size()) {
                            System.out.println("Opção inválida!");
                            break;
                            }
                            Animais animall = cadastrados.get(opcao1- 1);
                            System.out.print("Digite o tratamento: ");
                            String descricao = scan.nextLine();
                            Validacao.validarNome(descricao);
                            Tratamento tratamento = new Tratamento(descricao);
                            controleSaude.registrarTratamento(animall, tratamento);
                        } catch (NomeInvalidoException e) {
                            System.out.println(e.getMessage());
                        } catch (DateTimeParseException e) {
                            System.out.println(e.getMessage());
                        } catch (TratamentoDuplicadaException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 0:
                        rodando1 = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
            break;
            case 2:
                if (cadastrados.isEmpty()) {
                    System.out.println("Não existem animais cadastrados!");
                    break;
                }
                for (int i = 0; i < cadastrados.size(); i++) {
                        System.out.println((i + 1) + " - " + cadastrados.get(i).getNome());
                }
                    System.out.print("Escolha o animal: ");
                    int opcao1 = scan.nextInt();
                    scan.nextLine();
                    if (opcao1 < 1 || opcao1 > cadastrados.size()) {
                    System.out.println("Opção inválida!");
                    break;;
                    }
                    Animal animall = cadastrados.get(opcao1 - 1);
                    boolean rodando2 = true;
                    while (rodando2) {
                        System.out.println("\n     ATUALIZAR INFORMAÇÕES MÉDICAS      ");
                        System.out.println("1 - Atualizar estado de saúde");
                        System.out.println("2 - Atualizar vacina");
                        System.out.println("3 - Atualizar medicamento");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcao = scan.nextInt();
                        scan.nextLine();
                        switch (opcao) {
                            case 1:
                                String saude = Selecao.selecionarSaude(); 
                                animall.setEstadoSaude(saude);
                                rodando2 = false;
                                break;
                            case 2:
                                boolean rodandoo = true;
                                while(rodandoo){
                                System.out.println("\n      GERENCIAR VACINAS         ");
                                System.out.println("1 - Adicionar vacina");
                                System.out.println("2 - Remover vacina");
                                System.out.println("0 - Voltar");
                                System.out.print("Escolha: ");
                                int opcao3   = scan.nextInt();
                                scan.nextLine();
                                switch (opcao3) {
                                    case 1:
                                        System.out.println("Digite o nome da vacina:");
                                        String nomeVacina = scan.nextLine();
                                        Validacao.validarNome(nomeVacina);
                                        Vacina vacina = new Vacina(nomeVacina);
                                        controleSaude.registrarVacina(animall, vacina);
                                        System.out.println("Vacina registrada com sucesso");
                                        rodandoo = false;
                                        break;
                                    case 2:
                                        ArrayList<Vacina> vacinas = animall.getHistoricoMedico().getVacinas();
                                        if (vacinas.isEmpty()) {
                                            System.out.println("Não existem vacinas!");
                                            break;
                                        }
                                        for (int i = 0; i < vacinas.size(); i++) {
                                            System.out.println((i + 1) + " - " +
                                            vacinas.get(i).gerarRelatorio());
                                        }
                                        System.out.print("Escolha a vacina que deseja remover: ");
                                        int indice = scan.nextInt() - 1;
                                        scan.nextLine();
                                        controleSaude.removerVacina(animall, indice);
                                        System.out.println("Vacina removida com sucesso!");
                                        rodandoo = false;
                                        break;
                                     case 0:
                                        rodandoo = false;
                                        break;
                                    default:
                                        System.out.println("Digite um número válido");
                                        break;
                                    break;
                                }
                            }
                            case 3:
                                boolean rodandoo1 = true;
                                while(rodandoo1){
                                System.out.println("\n      GERENCIAR MEDICAMENTOS         ");
                                System.out.println("1 - Adicionar medicamento");
                                System.out.println("2 - Remover medicamento");
                                System.out.println("0 - Voltar");
                                System.out.print("Escolha: ");
                                int opcao4   = scan.nextInt();
                                scan.nextLine();
                                switch (opcao4) {
                                    case 1:
                                       System.out.println("Digite o nome do medicamento:");
                                        String nomeMedicamento = scan.nextLine();
                                       Validacao.validarNome(nomeMedicamento);
                                       Medicamento medicamento = new Medicamento(nomeMedicamento);
                                       controleSaude.registrarMedicamento(nomeMedicamento);
                                        System.out.println("Medicamento registrado cosucesso");
                                        rodandoo1 = false;
                                        break;
                                     case 2:
                                        ArrayList<Medicamento> medicamentos = animall.getHistoricoMedico().getMedicamentos();
                                        if (medicamentos.isEmpty()) {
                                            System.out.println("Não existem consultacadastradas!");
                                                    break;
                                                }
                                                for (int i = 0; i < medicamentos.size(); i++) {
                                                    System.out.println((i + 1) + " - " +
                                                    medicamentos.get(i).gerarRelatorio());
                                                }
                                                System.out.print("Escolha a vacina que deseja remover: ");
                                                int indice = scan.nextInt() - 1;
                                                scan.nextLine();
                                                controleSaude.removerMedicamento(animall, indice);
                                                System.out.println("Medicamento removida com sucesso!");
                                                rodandoo1 = false;
                                                break;
                                            case 0:
                                                rodandoo1 = false;
                                                break;
                                            default:
                                                break;
                                            }
                                        } 
                        }               
                        case 3:
                             if (cadastrados.isEmpty()) {
                                System.out.println("Não existem animais cadastrados!");
                                break;
                            }
                            for (int i = 0; i < cadastrados.size(); i++) {
                                System.out.println((i + 1) + " - " + cadastrados.get(i).getNome());
                            }
                            System.out.print("Escolha o animal: ");
                            int opcao6 = scan.nextInt();
                            scan.nextLine();
                            if (opcao6 < 1 || opcao6 > cadastrados.size()) {
                            System.out.println("Opção inválida!");
                            break;
                            }
                            Animais animalll = cadastrados.get(opcao6 - 1);
                            if (animalll != null) {
                                String relatorio = controleSaude.gerarRelatorio(animalll);
                                System.out.println(relatorio);
                            }
                            rodando = false;
                            break;
                        default:
                            System.out.println("Opção Inválida!!");
                            break;
                    }
        }}}
    @Override
    public String getTipoUsuario() {
        return "Veterinario";
    }
    public String getNome() {
        return nome;
    }
    
}
