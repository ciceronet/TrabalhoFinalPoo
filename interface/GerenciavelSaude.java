package interfaces;
public interface GerenciavelSaude {
    void registrarConsulta(Animais animal, Consulta consulta);

    void registrarVacina(Animais animal, Vacina vacina) throws VacinaDuplicadaException;

    void registrarMedicamento(Animais animal, Medicamento medicamento) throws MedicamentoDuplicadoException;

    void registrarTratamento(Animais animal, Tratamento tratamento) throws TratamentoDuplicadoException;
}