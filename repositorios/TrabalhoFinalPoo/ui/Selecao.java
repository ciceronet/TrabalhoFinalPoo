package ui;
import java.util.Scanner;
public final class Selecao {

    public static String SelecionarPorte() {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        int resposta;
            System.out.println("Opções de porte:");
            System.out.println("1 - Pequeno");
            System.out.println("2 - Médio");
            System.out.println("3 - Grande");
        while(rodando) {
            System.out.println("Selecione o porte do seu animal");
            } try {
                resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    rodando = false;
                    return "Pequeno";
                case 2:
                    rodando = false;
                    return "Médio";
                case 3:
                    rodando = false;
                    return "Grande";
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }} catch (Exception e) {
                System.out.println("Erro! Argumento Inválido");
                scanner.next();
            }
            return null;
        }
    public static String RacaCachorro() {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        int resposta;
        System.out.println("         RAÇAS DE CACHORRO         ");
        System.out.println("1 - Shih Tzu");
        System.out.println("2 - Pug");
        System.out.println("3 - Poodle");
        System.out.println("4 - Golden Retriever");
        System.out.println("5 - Labrador Retriever");
        System.out.println("6 - Border Collie");
        System.out.println("7 - Pastor Alemão");
        System.out.println("8 - Husky Siberiano");
        System.out.println("9 - Rottweiler");
        while(rodando) {
            System.out.println("Selecione a raça do seu cachorro:");
            try {
                resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    rodando = false;
                    return "Shih Tzu";
                case 2:
                    rodando = false;
                    return "Pug";
                case 3:
                    rodando = false;
                    return "Poodle";
                case 4:
                    rodando = false;
                    return "Golden Retriever";
                case 5:
                    rodando = false;
                    return "Labrador Retriever";
                case 6:
                    rodando = false;
                    return "Border Collie";
                case 7:
                    rodando = false;
                    return "Pastor Alemão";
                case 8:
                    rodando = false;
                    return "Husky Siberiano";
                case 9:
                    rodando = false;
                    return "Rottweiler";
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }}  catch (Exception e) {
            System.out.println("Erro! Entrada inválida.");
            scanner.next();
            }
        }
        return null;
    }

    public static String RacaGato() {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        int resposta;
        System.out.println("--- RAÇAS DE GATO ---");
        System.out.println("1 - Maine Coon");
        System.out.println("2 - Persa");
        System.out.println("3 - Ragdoll");
        System.out.println("4 - Siamês");
        System.out.println("5 - Angorá Turco");
        System.out.println("6 - American Shorthair");
        System.out.println("7 - Sphynx");
        System.out.println("8 - Bengal");
        System.out.println("9 - Scottish Fold");
        while (rodando) {
        System.out.println("Selecione a raça do seu gato:");
        try {
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    return "Maine Coon";
                case 2:
                    return "Persa";
                case 3:
                    return "Ragdoll";
                case 4:
                    return "Siamês";
                case 5:
                    return "Angorá Turco";
                case 6:
                    return "American Shorthair";
                case 7:
                    return "Sphynx";
                case 8:
                    return "Bengal";
                case 9:
                    return "Scottish Fold";
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro! Entrada inválida.");
            scanner.next();
        }
    }
    return null;
    }
    public static String selecionarSaude() { 
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        int resposta;
        System.out.println("       Saúde do Animal        ");
        System.out.println("1 - Saudável");
        System.out.println("2 - Doente");
        while (rodando) {
        System.out.println("Selecione a saúde do seu Animal:");
        try {
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    rodando = false;
                    return "Saudável";
                case 2:
                    rodando = false;
                    return "Doente";
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro! Entrada inválida.");
            scanner.next();
        }
        }
        return null;
    }
    public static String selecionarAtividade() {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        int resposta;
        System.out.println("       Atividades        ");
        System.out.println("1 - Mutirão de limpeza");
        System.out.println("2 - Campanhas de vacinação");
        System.out.println("3 - Feiras de adoção");
        System.out.println("4 - Eventos beneficentes");
        while (rodando) {
        System.out.println("Selecione a atividade que deseja participar:");
        try {
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    rodando = false;
                    return "Multirão de limpeza";
                case 2:
                    rodando = false;
                    return "Campanhas de vacinação";
                case 3:
                    rodando = false;
                    return "Feiras de adoção";
                case 4:
                    rodando = false;
                    return "Eventos beneficentes";
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro! Entrada inválida.");
            scanner.next();
        }
        }
        return null;
    }
}



