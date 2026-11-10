package modelo;
import java.time.LocalDate;
import exceptions.AtividadeException;
import service.Validacao;


public class Atividade {
    private int vagas;
    private LocalDate data;
    private String tipo;
    public Atividade (int vagas, LocalDate data, String tipo) throws AtividadeException {
        Validacao.validarVagas(vagas);
        Validacao.validarData(data);
        setTipo(tipo);
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
    public void setVagas(int vagas) throws AtividadeException{
        Validacao.validarVagas(vagas);
        this.vagas = vagas;
    }
    public void setData(LocalDate data) throws AtividadeException{
        Validacao.validarData(data);
        this.data = data;
    }
    public void setTipo (String tipo) {
        this.tipo = tipo;
    }
}
