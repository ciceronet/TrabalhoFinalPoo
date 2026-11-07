package modelo;
import java.time.LocalDate;
import exceptions.AtividadeException;

public class Atividade {
    private String nome;
    private int vagas;
    private LocalDate data;
    private String tipo;
    public Atividade (String nome, int vagas, LocalDate data, String tipo) throws AtividadeException {
        Validacao.validarTarefa(nome);
        Validacao.validarVagas(vagas);
        Validacao.validarData(data);
        setTipo(tipo);
    }
     public String getNome(){
        return this.nome;
    }
    public int getVagas(){
        return this.vagas;
    }
     public String getTipo(){
        return this.tipo;
    }
    public LocalDate getData(){
        return this.data;
    }
    public void setNome(String nome) throws AtividadeException{
        Validacao.validarTarefa(nome);
        this.nome = nome;
    }
    public void setVagas(int vagas) throws AtividadeException{
        Validacao.validarVagas(vagas);
        this.vagas = vagas;
    }
    public void setData(LocalDate data) throws AtividadeException{
        Validacao.validarData(data);
        this.data = data;
    }
    public void setTipo (String tipo) {

    }
}