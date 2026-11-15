package modelo;

import java.time.LocalDate;

public class Consulta extends RegistroMedico {
    public Consulta(LocalDate data, String descricao){
        super(descricao, data);
    }

    @Override
    public String gerarRelatorio(){
    return "Consulta: " + getDescricao() + " | Data: " + getData();
    }
}
