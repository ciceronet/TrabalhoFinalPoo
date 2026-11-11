package ui;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import enums.*;
import exceptions.AtividadeException;
import service.*;
public class TelaPrincipal {
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static void telaCriarAtividade() {
        AtividadeService atividadeservice = new AtividadeService();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Número de vagas :");
            int vagas = Integer.parseInt(scanner.nextLine().trim());
            LocalDate data = lerData();
            TipoAtividade tipo = Selecao.selecionarAtividade();
            atividadeservice.criarAtividade(vagas, data, tipo);
            } catch (AtividadeException e) {
                System.out.println("Erro ao criar atividade: " + e.getMessage());
            }
            catch (NumberFormatException e) {
                System.out.println("Erro: O número de vagas deve ser um valor inteiro válido!");
            }
    }
    public static LocalDate lerData() {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
         while (rodando) {
                System.out.println("Digite a data do evento dd/mm/aa");
                String entrada = scanner.nextLine().trim();
                try {
                    return LocalDate.parse(entrada, formatador);
                } catch(DateTimeParseException e) {
                    System.out.println("Data Inválida! Insira no formato dd/mm/yy!");
                }
            }
            return null;
    }
}
