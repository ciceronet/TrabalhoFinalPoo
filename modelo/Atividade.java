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
    public Atividade (int vagas, LocalDate data, TipoAtividade tipo) throws AtividadeException{
        Validacao.validarVagas(vagas);
        Validacao.validarDataAtividade(data);
        setTipo(tipo);
        this.vagas = vagas;
        this.data = data;
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
    public void setTipo (TipoAtividade tipo) throws AtividadeException {
        if (tipo == null){
            throw new AtividadeException("Erro! Escolha o tipo da atividade!");
        }
        this.tipo = tipo;
    }
    public int getVagasRestantes(){
        return vagas - voluntarios.size();
    }
    public List<Voluntario> getVoluntarios(){
        return new ArrayList<>(voluntarios);
    }

    public void inscreverVoluntario(Voluntario voluntario) throws AtividadeException{
        if (voluntario == null) {
            throw new AtividadeException("Erro! Voluntário inválido!");
        }
        if (data.isBefore(LocalDate.now())){
            throw new AtividadeException("Erro! Não é possível se inscrever em uma atividade que já ocorreu!");
        }
        for (Voluntario v : voluntarios){
            if (v.getEmail().equalsIgnoreCase(voluntario.getEmail())){
                throw new AtividadeException("Erro! Não é possível se inscrever duas vezes na mesma atividade!");
            }
        }
        if (getVagasRestantes() <= 0){
            throw new AtividadeException("Erro! Não há vagas disponíveis para esta atividade!");
        }
        voluntarios.add(voluntario);
    }
}
