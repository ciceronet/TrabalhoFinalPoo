package service;

import modelo.*;
import interfaces.GerenciavelSaude;
import exceptions.*;

public class ControleSaude implements GerenciavelSaude {

    @Override
    public void registrarConsulta( Animais animal, Consulta consulta) throws AcessoNegadoException, ConsultaDuplicadaException {
        animal.getHistoricoMedico().adicionarConsulta(consulta);
    }
    @Override
    public void registrarVacina( Animais animal, Vacina vacina) throws VacinaDuplicadaException {
        animal.getHistoricoMedico().adicionarVacina(vacina);
    }

    @Override
    public void registrarMedicamento( Animais animal, Medicamento medicamento) throws MedicamentoDuplicadoException {
        animal.getHistoricoMedico().adicionarMedicamento(medicamento);
    }

    @Override
    public void registrarTratamento( Animais animal, Tratamento tratamento) throws     TratamentoDuplicadoException {
        animal.getHistoricoMedico().adicionarTratamento(tratamento);
    }

    public String gerarRelatorio(Animais animal) {
        String relatorio = "     Relatório de saúde:      \n";
        relatorio += "Animal: " + animal.getNome() + "\n";
        relatorio += "Espécie: " + animal.getEspecie() + "\n";
        relatorio += "Raça: " + animal.getRaca() + "\n";
        relatorio += "Estado de saúde: " + animal.getEstadoSaude() + "\n";
        HistoricoMedico historico = animal.getHistoricoMedico();
        relatorio += "\n        CONSULTAS      \n";
        for (Consulta consulta : historico.getConsultas()) {
            relatorio += consulta.gerarRelatorio() + "\n";
        }
        relatorio += "\n         VACINAS      \n";
        for (Vacina vacina : historico.getVacinas()) {
            relatorio += vacina.gerarRelatorio() + "\n";
        }
        relatorio += "\n        MEDICAMENTOS       \n";
        for (Medicamento medicamento : historico.getMedicamentos()) {
            relatorio += medicamento.gerarRelatorio() + "\n";
        }
        relatorio += "\n       TRATAMENTOS      \n";
        for (Tratamento tratamento : historico.getTratamentos()) {
            relatorio += tratamento.gerarRelatorio() + "\n";
        }
    return relatorio;
    }
    public void removerConsulta( Animais animal, int indice)  {
        animal.getHistoricoMedico().removerConsulta(indice);
    }
    public void removerVacina(Animais animal, int indice) {
        animal.getHistoricoMedico().removerVacina(indice);
    }
    public void removerMedicamento(Animais animal, int indice) {
        animal.getHistoricoMedico().removerMedicamento(indice);
    }
    public void removerTratamento(Animais animal, int indice) {
        animal.getHistoricoMedico().removerTratamento(indice);
    }
    
}