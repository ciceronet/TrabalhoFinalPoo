package TrabalhoFinalPoo.Usuarios;

import TrabalhoFinalPoo.Exceptions.EmailInvalidoException;
import TrabalhoFinalPoo.Exceptions.NomeInvalidoException;
import TrabalhoFinalPoo.Exceptions.SenhaInvalidaException;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    public Usuario(String nome, String email, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        if (email == null || email.isBlank() ) { 
            throw new EmailInvalidoException("Email vazio");
        }
        if (!email.contains("@")) { 
            throw new EmailInvalidoException("Email não possui @");
        }   
        int posicaoArroba = email.indexOf("@");
        if (posicaoArroba == email.length() - 1) {
            throw new EmailInvalidoException("Email não possui domínio");
        }   
        if (senha.length() < 6) {
            throw new SenhaInvalidaException("Senha inválida");
        }
        if (nome == null || nome.isBlank()) {
            throw new NomeInvalidoException("Nome inválido");
        }
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
