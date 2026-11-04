package modelo;
import exceptions.*;
public class Admnistrador {
    public Admnistrador(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
}  
