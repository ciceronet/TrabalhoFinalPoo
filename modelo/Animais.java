package modelo;
import exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;




public class Animais {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private LocalDate dataResgate;
    private String status;
    private int posicao;
    public Animais(String nome, String especie, String raca, int idade,Porte porte,int posicao, LocalDate dataResgate, String status) throws NomeInvalidoException , IllegalArgumentException {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.posicao = posicao;
        this.dataResgate = dataResgate;
        this.status = status;

    }
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
     public int getPosicao(){
        return this.posicao;
    }
     public LocalDate getDataResgate(){
        return this.dataResgate;
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
    public ArrayList<Animais> filtroAnimais(ArrayList<Animais> cadastrados){
        
    }

}