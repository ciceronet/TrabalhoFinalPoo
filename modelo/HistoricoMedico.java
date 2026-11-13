package modelo;
public class HistoricoMedico {
    private ArrayList<Consulta> consultas;
    private ArrayList<Vacina> vacinas;
    private ArrayList<Medicamento> medicamentos;
    private ArrayList<Tratamento> tratamentos;
    public HistoricoMedico() {
        consultas = new ArrayList<>();
        vacinas = new ArrayList<>();
        medicamentos = new ArrayList<>();
        tratamentos = new ArrayList<>();
    }
    public void adicionarConsulta(Consulta consulta) throws ConsultaDuplicadaException {
    try {
        for (Consulta c : consultas) {
            if (c.getData().equals(consulta.getData()) && c.getDescricao().equalsIgnoreCase(consulta.getDescricao())) {
                throw new ConsultaDuplicadaException(c.getMessage("Consulta já cadastrada!"));
            }
        }
        consultas.add(consulta);
        } catch(ConsultaDuplicadaException e) {
            System.out.println(e.getMessage());
        }
    }
    public void adicionarVacina(Vacina vacina) throws VacinaDuplicadaException {
        try {
            for (Vacina v : vacinas) {
                if (v.getNome().equalsIgnoreCase(vacina.getDescricao())) {
                    throw new VacinaDuplicadaException(v.getMessage("Vacina já registrada!"));
                }
            }
            vacinas.add(vacina);
            } catch(VacinaDuplicadaexception e) {
                System.out.println(e.getMessage());
            }
    }
    public void adicionarMedicamento(Medicamento medicamento) throws MedicamentoDuplicadoException {
        try {
        for (Medicamento m : medicamentos) {
            if (m.getNome().equalsIgnoreCase(medicamento.getDescricao())) {
                throw new MedicamentoDuplicadoException( "Esse medicamento já foi cadastrado!");
            }
        }
        medicamentos.add(novo);
        } catch(MedicamentoDuplicadoexception e) {
            System.out.println(e.getMessage());
        }
    }

    public void adicionarTratamento(Tratamento tratamento) throws TratamentoDuplicadoException {
        try {
        for (Tratamento t : tratamentos) {
            if (t.getTipo().equalsIgnoreCase(tratamento.getDescricao())) {
                throw new TratamentoDuplicadoException("Esse tratamento já foi cadastrado!");
            }
        }
        tratamentos.add(novo);
        } catch(TratamentoDuplicadoException e) {
                System.out.println(e.getMessage());
        }
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
    if (indice < 0 || indice >= consultas.size()) {
        throw new IllegalArgumentException("Consulta não encontrada!");
    }
    consultas.remove(indice);
    }
    public void removerVacina(int indice) {
    if (indice < 0 || indice >= vacinas.size()) {
        throw new IllegalArgumentException("Vacina não encontrada!");
    }
    vacinas.remove(indice);
    }
    public void removerMedicamento(int indice) {
    if (indice < 0 || indice >= medicamentos.size()) {
        throw new IllegalArgumentException("Vacina não encontrada!");
    }
    medicamentos.remove(indice);
    }
    public void removerTratamento(int indice) {
    if (indice < 0 || indice >= tratamentos.size()) {
        throw new IllegalArgumentException("Vacina não encontrada!");
    }
    tratamentos.remove(indice);
    }
}