package modelo;
import java.time.LocalDate;
import exceptions.*;
import service.Validacao;
import java.util.ArrayList;
import java.util.List;
import enums.*;


public class Atividade {
    private int vagas;
    private LocalDate data;
    private TipoAtividade tipo;
    public Atividade (int vagas, LocalDate data, TipoAtividade tipo) throws AtividadeException {
        Validacao.validarVagas(vagas);
        Validacao.validarDataAtividade(data);
        this.vagas = vagas;
        this.data = data;
        this.tipo = tipo;
    }
    private List<Voluntario> voluntarios = new ArrayList<>();
    public int getVagas(){
        return this.vagas;
    }
     public TipoAtividade getTipo(){
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
        Validacao.validarDataAtividade(data);
        this.data = data;
    }
    public void setTipo (TipoAtividade tipo) {
        this.tipo = tipo;
    }
    public int getVagasRestantes() {
        return vagas - voluntarios.size();
    }
    public List<Voluntario> getVoluntarios() {
        return new ArrayList<>(voluntarios);
    }
    public void inscreverVoluntario(Voluntario voluntario) throws AtividadeException {
        try{
        if(voluntario == null) {
            throw new AtividadeException("Erro! Voluntário inválido!");
        }
        if(data.isBefore(LocalDate.now())) {
            throw new AtividadeException("Erro! Não é possível se inscrever em uma atividade que já ocorreu!");
        }
        int vagasPreenchidas = 0;
        for(Voluntario v : voluntarios) {
            if(v.getEmail().equalsIgnoreCase(voluntario.getEmail())) {
                throw new AtividadeException("Erro! Não é possível se inscrever duas vezes na mesma atividade!");
            }
            vagasPreenchidas++;
        }
        if (vagasPreenchidas >= vagas) {
            throw new AtividadeException("Erro! Não há vagas disponíveis para esta atividade!");
        }
        voluntarios.add(voluntario);
    } catch(AtividadeException e) {
        system.out.println(e.getMessage());
    }
    } 
}