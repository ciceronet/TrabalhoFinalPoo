package service;

import modelo.Atividade;
import enums.TipoAtividade;
import exceptions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Voluntario;
import java.util.List;
public class AtividadeService {
    private final List<Atividade> atividades = new ArrayList<>();
    public AtividadeService() {
    }
    public Atividade criarAtividade(int vagas, LocalDate data, TipoAtividade tipo) throws AtividadeException {
        Atividade atividade = new Atividade(vagas, data, tipo);
        atividades.add(atividade);
        return atividade;
    }
    public List<Atividade> atividadesAbertas() {
        ArrayList<Atividade> abertas = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a.getData().isAfter(LocalDate.now()) && a.getVagasRestantes() > 0) {
                abertas.add(a);
            }
        }
        return abertas;
    }

    public void inscrever(Atividade atividade, Voluntario voluntario) throws AtividadeException {
        atividade.inscreverVoluntario(voluntario);
        voluntario.registrarParticipacao(atividade);
    }
    public List<Atividade> atividadesRealizadas() {
        ArrayList<Atividade> realizadas = new ArrayList<>();
        for (Atividade a : atividades) {
            if(a.getData().isBefore(LocalDate.now())) {
                realizadas.add(a);
            }
        }
        return realizadas;
    }    
}

