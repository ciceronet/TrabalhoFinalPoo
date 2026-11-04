package modelo;
import exceptions.*;
import service.Validacao;
public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    public Usuario(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        Validacao.validarEmail(email);
        Validacao.validarNome(nome);
        Validacao.validarSenha(senha);
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    public abstract void Menu();
    public String getEmail() {
        return this.email;
    }
    public String getNome() {
        return this.nome;
    }
    public String getSenha() {
        return this.senha;
    }
}
