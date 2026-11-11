package modelo;
import exceptions.*;
import service.Validacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Animais {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private LocalDate dataResgate;
    private String status;
    private String estadoSaude;
    private static int id;

    Scanner sc = new Scanner(System.in);

    public Animais(String nome, String especie, String raca, int idade,String porte,int posicao, LocalDate dataResgate, String status, String estadoSaude) throws NomeInvalidoException , IllegalArgumentException {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.dataResgate = dataResgate;
        this.status = status;
        this.estadoSaude= estadoSaude;
        id++;
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
     public String getPorte(){
        return this.porte;
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
    public void setPorte(String porte) {
        this.porte=porte;
    }
    public void setDataDeNascimento (LocalDate dataResgate) {
        this.dataResgate=dataResgate;
    }
    public void setStatus(String status) {
        this.status=status;
    }
    public void cadastrarAnimal(ArrayList<Animais> cadastrados,Animais animal){
        cadastrados.add(animal);
    }
    public void editarRemover(ArrayList<Animais> cadastrados,Animais animal){
        cadastrados.remove(animal);
    }
    public void filtroAnimais(ArrayList<Animais> cadastrados){
        while(rodando) {
            System.out.println("1 - Nome");
            System.out.println("2 - Especie");
            System.out.println("3 - Raça");
            System.out.println("4 - Idade");
            System.out.println("5 - Porte");
            System.out.println("6 - Data de Resgate");
            System.out.println("7 - Status");
            System.out.println("8 - Estado de Saude");
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
                        System.out.print("Porte:"+u.getPorte()+" ");
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
                        System.out.print("Porte:"+u.getPorte()+" ");
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
                        System.out.print("Porte:"+u.getPorte()+" ");
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
                        System.out.print("Porte:"+u.getPorte()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 5:
                 String buscaD=sc.nextLine();
               for (Animais u : cadastrados) {
                    if (u.getPorte().equalsIgnoreCase(buscaD)){ 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Porte:"+u.getPorte()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 6:
                 LocalDate buscaE = LocalDate.parse(sc.nextLine());
               for (Animais u : cadastrados) {
                    if (u.getDataResgate()==(buscaE)) { 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Porte:"+u.getPorte()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                    break;
                case 7:
                 String buscaF=sc.nextLine();
               for (Animais u : cadastrados) {
                    if (u.getStatus().equalsIgnoreCase(buscaF)){ 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Porte:"+u.getPorte()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                    }
                }
                     break;
                case 8:
                String buscaR=sc.nextLine();
               for (Animais u : cadastrados) {
                    if (u.getEstadoSaude().equalsIgnoreCase(buscaR)){ 
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Porte:"+u.getPorte()+" ");
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

                    break;
            }
        }
      
    }

}