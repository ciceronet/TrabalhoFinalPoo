package UsuarioService;

import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.SenhaInvalidaException;
import java.util.ArrayList;
import java.util.Lista;
import java.util.scanner;
import modelo.*;
import service.Validacao;

public class UsuarioService {
    List<Usuario> usuarios = new ArrayList<>();
    public UsuarioService() {}
    public static void cadastro(List<Usuario> usuarios) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException{
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        while (rodando) {
            try {
                System.out.println("Digite seu email:");
                String email = scanner.nextLine();
                Validacao.validarEmail(email);
                for(Usuario u : usuarios) {
                    if(u.getEmail().equalsIgnoreCase(email) && u.getSenha().equals(senha)) {
                    System.out.println("Login realizado com sucesso");
                    return;
                }
                }
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                Validacao.validarNome(nome);
                System.out.println("Digite a Senha:");
                String senha = scanner.nextLine();
                Validacao.validarSenha(senha);
                Veterinario novoVeterinario = new Veterinario(email, nome, senha);
                usuarios.add(novoVeterinario);
                System.out.println("Cadastro realizado com sucesso");
                rodando = false;
                return;
            } catch (EmailInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (NomeInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static Usuario Login(List<Usuario> usuarios,Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("    Login     ");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        for(Usuario u : usuarios) {
            if(u.getEmail().equalsIgnoreCase(email) && u.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso");
                return u;
            }
        }
        System.out.println("Nenhum usuário encontrado, Email ou senha incorretos");
        return null;
    }
}
