package modelo;

import java.util.ArrayList;
import java.util.Scanner;
import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.SenhaInvalidaException;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    public Usuario(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    Scanner sc=new Scanner(System.in);
    public abstract void Menu(ArrayList<Animais> cadastrados,ArrayList<Animais> adotados,ArrayList<Animais> tratando,ArrayList<Voluntario> voluntarios, ArrayList<Veterinario> veterinarios,ArrayList<Atividade> eventos, ArrayList<Notificacao> notifica,ArrayList<SolicitacaoAdocao>solicitacoes,Scanner sc);
    public String getEmail() {
        return this.email;
    }
    public String getNome() {
        return this.nome;
    }
    public String getSenha() {
        return this.senha;
    }

    public abstract String getTipoUsuario();
    public void Menu1(ArrayList<Animais> cadastrados, ArrayList<Animais> adotados, ArrayList<Animais> tratando,
            ArrayList<Voluntario> voluntarios, ArrayList<Veterinario> veterinarios, ArrayList<Atividade> eventos,
            ArrayList<Notificacao> notifica) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Menu1'");
    }
}