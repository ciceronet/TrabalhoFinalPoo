package modelo;
import exceptions.*;
import service.Validacao;
import java.time.LocalDate;
public class Animais {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private LocalDate dataResgate;
    private String status;
    public Animais(String nome, String especie, String raca, int idade,Porte porte,int posicao, LocalDate dataResgate, String status) throws NomeInvalidoException, IllegalArgumentException {
        Validacao.validarNome(nome);
        (especie);
        (raca);
        Validacao.validarIdade(idade);
        (posicao);
        (dataResgate);
        (status);
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.posicao = posicao;
        this.dataResgate = dataResgate;
        this.status = status;

    }
    public void setNome(String nome) throws NomeInvalidoException{
        Validacao.validarNome(nome);
        this.nome = nome;
    }
    public void setEspecie(String especie) {

    }
    public void setRaca(String raca) {

    }
    public void setIdade(int idade) throws IdadeInvalidaException {
        Validacao.validarIdade(idade);
        this.idade = idade;
    }
    public void setPorte(String porte) {

    }
    public void setDataDeNascimento (LocalDate dataNascimento) {

    }
    public void setStatus(String status) {
        
    }
}
