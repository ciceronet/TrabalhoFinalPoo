package ui;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import enums.*;
import exceptions.AtividadeException;
import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;
import modelo.Atividade;
import modelo.Voluntario;
import service.*;
public class TelaPrincipal {
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void telaCriarAtividade(AtividadeService atividadeservice) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Número de vagas :");
            int vagas = scanner.nextInt();
            LocalDate data = lerData();
            TipoAtividade tipo = Selecao.selecionarAtividade();
            atividadeservice.criarAtividade(vagas, data, tipo);
            System.out.println("Atividade criada com sucesso!!");
            } catch (InputMismatchException e) {
                System.out.println("Erro: O número de vagas deve ser um valor inteiro válido!");
            }catch (AtividadeException e) {
                System.out.println("Erro ao criar atividade: " + e.getMessage());
            }
            scanner.close();
    }
    public static LocalDate lerData() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         while (true) {
                System.out.println("Digite a data do evento dd/mm/yyyy");
                String entrada = scanner.nextLine().trim();
                try {
                    scanner.close();
                    return LocalDate.parse(entrada, formatador);
                } catch(DateTimeParseException e) {
                    System.out.println("Data Inválida! Insira no formato dd/mm/yyyy!");
                }
        }
    }
    public static List<Atividade> atividadesDisponiveis(AtividadeService atividadesService) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Atividade> abertas = atividadesService.atividadesAbertas();
        if(abertas.isEmpty()) {
            System.out.println("Não há atividades abertas no momento");
            return abertas;
        }
        System.out.println("Atividades Abertas");
        for(int i  = 0; i < abertas.size();i++) {
            Atividade a = abertas.get(i);
            System.out.println((i + 1) + " - " + a.getTipo().getDescricao()+ " | Data: " + a.getData().format(formatador)+ " | Vagas restantes: " + a.getVagasRestantes());
        }
        return abertas;
    }

    public static void telaInscricao(AtividadeService atividadeService, Voluntario voluntario) {
        Scanner scanner = new Scanner(System.in);
        List<Atividade> abertas = atividadesDisponiveis(atividadeService);
        if(abertas.isEmpty()) {
            scanner.close();
            return;
        }
        System.out.println("0 - Voltar");
        System.out.println("Selecione a atividade desejada:");
        try {
            int resposta = scanner.nextInt();
            if(resposta == 0) {
                scanner.close();
                return;
            }
            if(resposta < 1 || resposta > abertas.size()) {
                System.out.println("Opção Inválida");
            }
            Atividade escolhida = abertas.get(resposta - 1);
            atividadeService.inscrever(escolhida, voluntario);
            System.out.println("Inscrição realizada com sucesso!");
        } catch(InputMismatchException e) {
            System.out.println("Erro! Digite apenas um número");
        } catch(AtividadeException e) {

        }
        scanner.close();
    }
    public static List<Atividade> atividadesIndisponiveis(AtividadeService atividadeService) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Atividade> fechadas = AtividadesService.atividadesRealizadas();
        if(fechadas.isEmpty()) {
            System.out.prinln("Nenhuma Atividade foi concluída ainda");
            return fechadas;
        }
        System.out.println("Atividades Realizadas:");
        for(int i  = 0; i < fechadas.size();i++) {
            Atividade a = fechadas.get(i);
            System.out.println((i + 1) + " - " + a.getTipo().getDescricao()+ " | Data: " + a.getData().format(formatador));
        }
    }
    public static void telaMenu(List<Usuario> usuarios) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {

        }
    }

