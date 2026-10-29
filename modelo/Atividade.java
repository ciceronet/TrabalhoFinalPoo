package modelo;

import java.time.LocalDate;
import exceptions.AtividadeException;

public class Atividade {
    private String nome;
    private int vagas;
    private LocalDate data;
    private TipoAtividade tipo;
    public Atividade (String nome, int vagas, LocalDate data, TipoAtividade tipo) throws AtividadeException {
        setNome(nome);
        setVagas(vagas);
        setData(data);
        setTipo(tipo);
    }
    public void setNome(String nome) throws AtividadeException{
        if(nome == null || nome.isBlank()) {
            throw new AtividadeException("Erro! Título vazio!");
        }
        this.nome = nome;
    }
    public void setVagas(int vagas) throws AtividadeException{
        if (vagas <= 0) {
            throw new AtividadeException("Erro! Número de vagas precisa ser maior que 0!");
        }
        this.vagas = vagas;
    }
    public void setData(LocalDate data) throws AtividadeException{
        if(data == null || data.isBefore(LocalDate.now())) {
            throw new AtividadeException("Erro! Data está no passdo!");
        }
        this.data = data;
    }
    public void setTipo (TipoAtividade tipo) {

    }
}
