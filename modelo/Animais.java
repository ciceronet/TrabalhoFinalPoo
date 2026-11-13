package modelo;
import exceptions.*;
import service.Validacao;
import ui.Selecao;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Animais {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private LocalDate dataResgate;
    private String status;
    private String estadoSaude;
    private final int id;
    private HistoricoMedico historicoMedico;
     private static int contadorId = 0;
    Scanner sc = new Scanner(System.in);

    public Animais(int id,String nome, String especie, String raca, int idade,LocalDate dataResgate, String status, String estadoSaude) throws NomeInvalidoException , IllegalArgumentException {
        contadorId++;
        this.id = contadorId;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.dataResgate = dataResgate;
        this.status = "Disponível";
        this.estadoSaude= estadoSaude;
        this.historicoMedico = new HistoricoMedico();
    }
    private int resposta;
    private boolean rodando=true;

    public String getNome(){
        return this.nome;
    }
     public String getEspecie(){
        return this.especie;
    }
     public String getRaca(){
        return this.raca;
    }
     public String getStatus(){
        return this.status;
    }
     public int getIdade(){
        return this.idade;
    }
     public LocalDate getDataResgate(){
        return this.dataResgate;
    }
    public String getEstadoSaude(){
        return this.estadoSaude;
    }
    public int getId(){
        return id;
    }
    public HistoricoMedico getHistoricoMedico() {
    return historicoMedico;
    }
    public void setEstadoSaude(String estadoSaude){
        this.estadoSaude = estadoSaude;
    }
    public void setNome(String nome) throws NomeInvalidoException{
        Validacao.validarNome(nome);
        this.nome = nome;
    }
    public void setEspecie(String especie) {
        this.especie=especie;
    }
    public void setRaca(String raca) {
        this.raca=raca;
    }
    public void setIdade(int idade) throws IdadeInvalidaException {
        Validacao.validarIdade(idade);
        this.idade = idade;
    }
    public void setDataResgate(LocalDate dataResgate) {
        this.dataResgate=dataResgate;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public static void cadastrarAnimal(ArrayList<Animais> animais, Scanner sc) {
        try {
    System.out.println("\n      CADASTRAR ANIMAL     ");

    System.out.print("Digite o ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    System.out.print("Digite o nome: ");
    String nome = sc.nextLine();
    Validacao.validarNome(nome);

    String especie = Selecao.selecionarEspecie();
    String raca;
    if(especie.equalsIgnoreCase(Cahorro)) {
        raca = Selecao.RacaCachorro();
    } else if (especie.equalIgnoreCase(Gato)) {
        raca = Selecao.RacaGato();
    }
    System.out.print("Digite a idade: ");
    int idade = sc.nextInt();
    if (idade <= 0 || idade >= 25) {
        throw new IllegalArgumentException("Idade Incorreta, digite entre 0 e 25");
    }
    sc.nextLine();
    System.out.print("Digite a data de resgate (AAAA-MM-DD): ");
    LocalDate dataResgate = LocalDate.parse(sc.nextLine());

    System.out.print("Digite o status: ");
    String status = sc.nextLine();
    Validacao.validarNome(status);
    String estadoSaude = Seleceo.selecionarSaude();
    Animais novoAnimal=null;
        novoAnimal = new Animais(id,nome,especie,raca,idade, dataResgate,status,estadoSaude);
    } catch (InputMismatchException e) {
    System.out.println("Digite a informação correta!");
    sc.nextLine();  
    } catch (NomeInvalidoException e) {
    System.out.println(e.getMessage());
    } catch (DateTimeException e) {
    System.out.println("Data inválida!");
    } catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
    } catch (Exception e) {
        System.out.prinln("Erro!");
    }
    animais.add(novoAnimal);

    System.out.println("\nAnimal cadastrado com sucesso!");
    }
    public static void gerenciarAnimal(ArrayList<Animais> animais, Scanner sc) {

    Animais animalEncontrado = null;
    System.out.println("\n     BUSCAR ANIMAL     ");
    System.out.println("1 - Buscar por ID");
    System.out.println("2 - Buscar por Nome");
    System.out.print("Escolha: ");

    int opcaoBusca = sc.nextInt();
    sc.nextLine();

    switch (opcaoBusca) {

        case 1:
            System.out.print("Digite o ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Animais a : animais) {
                if (a.getId() == id) {
                    animalEncontrado = a;
                    break;
                }
            }
            break;

        case 2:
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();

            for (Animais a : animais) {
                if (a.getNome().equalsIgnoreCase(nome)) {
                    animalEncontrado = a;
                    break;
                }
            }
            break;

        default:
            System.out.println("Opção inválida!");
            return;
    }
    if (animalEncontrado == null) {
        System.out.println("Animal não encontrado!");
        return;
    }

    System.out.println("\nAnimal encontrado:");
    System.out.println(animalEncontrado);

    System.out.println("\n     GERENCIAR ANIMAL     ");
    System.out.println("1 - Excluir");
    System.out.println("2 - Editar");
    System.out.print("Escolha: ");

    int opcao = sc.nextInt();
    sc.nextLine();

    switch (opcao) {

        case 1:
            animais.remove(animalEncontrado);
            System.out.println("Animal excluído com sucesso!");
            break;

        case 2:

            int editar = -1;

            while (editar != 0) {

                System.out.println("\n      EDITAR ANIMAL       ");
                System.out.println("1 - Nome");
                System.out.println("2 - Espécie");
                System.out.println("3 - Raça");
                System.out.println("4 - Idade");
                System.out.println("5 - Data de Resgate");
                System.out.println("6 - Status");
                System.out.println("7 - Estado de Saúde");
                System.out.println("0 - Finalizar edição");

                System.out.print("Escolha: ");
                editar = sc.nextInt();
                sc.nextLine();

                switch (editar) {

                    case 1:
                        System.out.print("Novo nome: ");
                        try {
                            animalEncontrado.setNome(sc.nextLine());
                        } catch (NomeInvalidoException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        System.out.print("Nova espécie: ");
                        animalEncontrado.setEspecie(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Nova raça: ");
                        animalEncontrado.setRaca(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("Nova idade: ");
                        try {
                            animalEncontrado.setIdade(sc.nextInt());
                        } catch (IdadeInvalidaException e) {
                            e.printStackTrace();
                        }
                        sc.nextLine();
                        break;

                    case 5:
                        System.out.print("Nova data de resgate (AAAA-MM-DD): ");
                        animalEncontrado.setDataResgate(
                            LocalDate.parse(sc.nextLine())
                        );
                        break;

                    case 6:
                        System.out.print("Novo status: ");
                        animalEncontrado.setStatus(sc.nextLine());
                        break;

                    case 7:
                        System.out.print("Novo estado de saúde: ");
                        animalEncontrado.setEstadoSaude(sc.nextLine());
                        break;

                    case 0:
                        System.out.println("Edição finalizada!");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            }
            break;

        default:
            System.out.println("Opção inválida!");
    }

    }
    public void filtroAnimais(ArrayList<Animais> cadastrados){
        while(rodando) {
            System.out.println("1 - Nome");
            System.out.println("2 - Especie");
            System.out.println("3 - Raça");
            System.out.println("4 - Idade");
            System.out.println("5 - Data de Resgate");
            System.out.println("6 - Status");
            System.out.println("7 - Estado de Saude");
            System.out.println("0 - Sair");
            resposta = sc.nextInt(); 
            switch (resposta) {
                case 1:
                String busca=sc.nextLine();
               for (Animais u : cadastrados) {
                    if (u.getNome().equalsIgnoreCase(busca)) { 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 2:
                 String buscaA=sc.nextLine();
               for (Animais u : cadastrados) {
                    if (u.getEspecie().equalsIgnoreCase(buscaA)) { 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 3:
                String buscaB=sc.nextLine();
               for (Animais u : cadastrados) {
                    if (u.getRaca().equalsIgnoreCase(buscaB)) { 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 4:
                int buscaC=sc.nextInt();
               for (Animais u : cadastrados) {
                    if (u.getIdade()==buscaC) { 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 5:
                 LocalDate buscaE = LocalDate.parse(sc.nextLine());
               for (Animais u : cadastrados) {
                    if (u.getDataResgate()==(buscaE)) { 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 6:
                 String buscaF=sc.nextLine();
               for (Animais u : cadastrados) {
                    if (u.getStatus().equalsIgnoreCase(buscaF)){ 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                     break;
                case 7:
                String buscaR=sc.nextLine();
               for (Animais u : cadastrados) {
                    if (u.getEstadoSaude().equalsIgnoreCase(buscaR)){ 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 0:
                    rodando=false;
                    System.out.println("Sistema de Busca fechado!");
                    break;
                default:
                System.out.print("Digite uma opção valida");
                    break;
            }
        }
      sc.close();
    }
    public boolean podeSerAdotado() {

        return !estadoSaude.equalsIgnoreCase("Crítico")
                && !status.equalsIgnoreCase("Adotado");
    }
}