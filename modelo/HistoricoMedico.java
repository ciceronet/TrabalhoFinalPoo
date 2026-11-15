package modelo;

import java.util.ArrayList;
import exceptions.*;

public class HistoricoMedico {
    private final ArrayList<Consulta> consultas = new ArrayList<>();
    private final ArrayList<Vacina> vacinas = new ArrayList<>();
    private final ArrayList<Medicamento> medicamentos = new ArrayList<>();
    private final ArrayList<Tratamento> tratamentos = new ArrayList<>();

    public void adicionarConsulta(Consulta consulta) throws ConsultaDuplicadaException{
        for (Consulta c : consultas){
            if (c.getData().equals(consulta.getData())
                    && c.getDescricao().equalsIgnoreCase(consulta.getDescricao())){
                throw new ConsultaDuplicadaException("Erro! Consulta já cadastrada nesta data!");
            }
        }
        consultas.add(consulta);
    }

    public void adicionarVacina(Vacina vacina) throws VacinaDuplicadaException{
        for (Vacina v : vacinas){
            if (v.getDescricao().equalsIgnoreCase(vacina.getDescricao())
                    && v.getData().equals(vacina.getData())){
                throw new VacinaDuplicadaException("Erro! Esta vacina já foi registrada nesta data!");
            }
        }
        vacinas.add(vacina);
    }

    public void adicionarMedicamento(Medicamento medicamento) throws MedicamentoDuplicadoException{
        for (Medicamento m : medicamentos){
            if (m.getDescricao().equalsIgnoreCase(medicamento.getDescricao())){
                throw new MedicamentoDuplicadoException("Erro! Esse medicamento já foi cadastrado!");
            }
        }
        medicamentos.add(medicamento);
    }

    public void adicionarTratamento(Tratamento tratamento) throws TratamentoDuplicadoException{
        for (Tratamento t : tratamentos){
            if (t.getDescricao().equalsIgnoreCase(tratamento.getDescricao())){
                throw new TratamentoDuplicadoException("Erro! Esse tratamento já foi cadastrado!");
            }
        }
        tratamentos.add(tratamento);
    }

    public ArrayList<Consulta> getConsultas() { 
    return new ArrayList<>(consultas); 
    }
    public ArrayList<Vacina> getVacinas() { 
    return new ArrayList<>(vacinas); 
    }
    public ArrayList<Medicamento> getMedicamentos() { 
    return new ArrayList<>(medicamentos); 
    }
    public ArrayList<Tratamento> getTratamentos() { 
    return new ArrayList<>(tratamentos);
    }
    public void removerConsulta(int indice) { 
    remover(consultas, indice, "Consulta"); 
    }
    public void removerVacina(int indice) { 
    remover(vacinas, indice, "Vacina"); 
    }
    public void removerMedicamento(int indice) { 
    remover(medicamentos, indice, "Medicamento"); 
    }
    public void removerTratamento(int indice) { 
    remover(tratamentos, indice, "Tratamento"); 
    }

    private void remover(ArrayList<?> lista, int indice, String nome){
        if (indice < 0 || indice >= lista.size()){
            throw new IllegalArgumentException(nome + " não encontrado(a)!");
        }
        lista.remove(indice);
    }
}
