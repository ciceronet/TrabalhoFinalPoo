package modelo;

import java.time.LocalDate;

public class Notificacao{
    private final String mensagem;
    private final LocalDate data = LocalDate.now();

    public Notificacao(String mensagem){
    this.mensagem = mensagem;
    }

    public String getMensagem(){ 
    return mensagem; 
    }
    public LocalDate getData(){ 
    return data; 
    }

    @Override
    public String toString(){
        return "[" + data + "] " + mensagem;
    }
}
