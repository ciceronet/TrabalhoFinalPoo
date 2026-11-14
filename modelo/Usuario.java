package modelo;

import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.SenhaInvalidaException;
import service.Contexto;
import service.Validacao;

public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String email, String nome, String senha)
            throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        setEmail(email);
        setNome(nome);
        setSenha(senha);
    }

    public void setEmail(String email) throws EmailInvalidoException {
        Validacao.validarEmail(email);
        this.email = email.trim().toLowerCase();
    }

    public void setNome(String nome) throws NomeInvalidoException {
        Validacao.validarNome(nome);
        this.nome = nome.trim();
    }

    public void setSenha(String senha) throws SenhaInvalidaException {
        Validacao.validarSenha(senha);
        this.senha = senha;
    }

    public String getEmail() { 
        return email; 
    }
    public String getNome() { 
        return nome; 
    }

    public boolean autenticar(String tentativa) {
        return senha.equals(tentativa);
    }

    public abstract void Menu(Contexto ctx);

    public abstract String getTipoUsuario();
}
