package modelo;
import exceptions.*;
import service.Validacao;
public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    public Usuario(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        setEmail(email);
        setNome(nome);
        setSenha(senha);
    }
    public void setEmail(String email) throws EmailInvalidoException{
        Validacao.validarEmail(email);
        this.email = email.toLowerCase();
    }
    public void setNome(String nome) throws NomeInvalidoException{
        Validacao.validarNome(nome);
        this.nome = nome;
    }
    public  void setSenha(String senha) throws SenhaInvalidaException{
        Validacao.validarSenha(senha);
        this.senha = senha;
    }
}
