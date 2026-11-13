package ui;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import enums.TipoAtividade;
import modelo.Atividade;
import service.*;
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
             try {
                resposta = scanner.nextInt();
            switch (resposta) {
                case 1:
                    rodando = false;
                    scanner.close();
                    return "Pequeno";
                case 2:
                    rodando = false;
                    scanner.close();
                    return "Médio";
                case 3:
                    rodando = false;
                    scanner.close();
                    return "Grande";
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }} catch (Exception e) {
                System.out.println("Erro! Argumento Inválido");
                scanner.next();
            }
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
                    scanner.close();
                    return "Shih Tzu";
                case 2:
                    rodando = false;
                    scanner.close();
                    return "Pug";
                case 3:
                    rodando = false;
                    scanner.close();
                    return "Poodle";
                case 4:
                    rodando = false;
                    scanner.close();
                    return "Golden Retriever";
                case 5:
                    rodando = false;
                    scanner.close();
                    return "Labrador Retriever";
                case 6:
                    rodando = false;
                    scanner.close();
                    return "Border Collie";
                case 7:
                    rodando = false;
                    scanner.close();
                    return "Pastor Alemão";
                case 8:
                    rodando = false;
                    scanner.close();
                    return "Husky Siberiano";
                case 9:
                    rodando = false;
                    scanner.close();
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
                    scanner.close();
                    rodando = false;
                    return "Maine Coon";
                case 2:
                    scanner.close();
                    rodando = false;
                    return "Persa";
                case 3:
                    scanner.close();
                    rodando = false;
                    return "Ragdoll";
                case 4:
                    scanner.close();
                    rodando = false;
                    return "Siamês";
                case 5:
                    scanner.close();
                    rodando = false;
                    return "Angorá Turco";
                case 6:
                    scanner.close();
                    rodando = false;
                    return "American Shorthair";
                case 7:
                    scanner.close();
                    rodando = false;
                    return "Sphynx";
                case 8:
                    scanner.close();
                    rodando = false;
                    return "Bengal";
                case 9:
                    scanner.close();
                    rodando = false;
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
                    scanner.close();
                    return "Saudável";
                case 2:
                    rodando = false;
                    scanner.close();
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
        scanner.close();
        return null;
    }
    public static TipoAtividade selecionarAtividade() {
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
                    scanner.close();
                    return TipoAtividade.MUTIRAO_LIMPEZA;
                case 2:
                    rodando = false;
                    scanner.close();
                    return TipoAtividade.CAMPANHA_VACINACAO;
                case 3:
                    rodando = false;
                    scanner.close();
                    return TipoAtividade.FEIRA_ADOCAO;
                case 4:
                    rodando = false;
                    scanner.close();
                    return TipoAtividade.EVENTO_BENEFICENTE;
                default:
                    System.out.println("Opção Inválida!!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Erro! Entrada inválida.");
            scanner.next();
        }
        }
        scanner.close();
        return null;
    }
    public static CandidatarAtividade() {
        System.out.println("Atividades disponíveis:");
        atividadesAbertas();
    }
    public static int selecionarClasse(List<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        int resposta;
        
        while (rodando) {
            System.out.println("        Usuários        ");
            System.out.println("1 - Voluntario");
            System.out.println("2 - Veterinário");
            System.out.println("Selecione a opção desejada:");
            
            try {
                resposta = scanner.nextInt();
                switch (resposta) {
                    case 1:
                        cadastroVoluntario(usuarios);
                        rodando = false;
                        return 1;
                    case 2:
                        cadastroVeterinario(usuarios); 
                        rodando = false;
                        return 2;
                    default:
                        System.out.println("Opção Inválida!!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro! Entrada inválida.");
                scanner.next(); 
            }
        }
        scanner.close();
        return 0;
    }
    public static String selecionarEspecie(Scanner scan) {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        while(rodando) {
        try{
            System.out.println("\n      SELECIONE A ESPÉCIE     ");
            System.out.println("1 - Cachorro");
            System.out.println("2 - Gato");
            System.out.print("Escolha: ");
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    scanner.close();
                    return "Cachorro";
                case 2:
                    scanner.close();
                    return "Gato";
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } catch(InputMismatchException e) {
            System.out.println("Erro! Digite um número");
            scanner.next();
        }
    }
    scanner.close();
    return null;
}
}


