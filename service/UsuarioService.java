package UsuarioService;

import exceptions.EmailInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.SenhaInvalidaException;
import modelo.Veterinario;

public class UsuarioService {
    List<Usuario> usuarios = new Usuario<>();
    public UsuarioService() {}
     public static Usuario cadastroVoluntario(List<Usuario> usuarios)throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            try {
                System.out.println("Digite seu email:");
                String email = scanner.nextLine();
                Validacao.validacarenail(email);
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                Validacao.validarNome(nome);
                System.out.println("Digite a Senha:");
                String senha = scanner.nextLine();
                Voluntario novoVoluntario = new Voluntario(email, nome, senha);
                usuarios.add(novoVoluntario);
                System.out.println("Cadastro realizado com sucesso");
                rodando = false;
                return novoVoluntario;
            } catch (EmailInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
    public static Usuario cadastroVeterinario(List<Usuario> usuarios) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException{
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            try {
                System.out.println("Digite seu email:");
                String email = scanner.nextLine();
                Validacao.validacarenail(email);
                System.out.println("Digite seu nome:");
                String nome = scanner.nextLine();
                Validacao.validarNome(nome);
                System.out.println("Digite a Senha:");
                String senha = scanner.nextLine();
                Veterinario novoVeterinario = new Veterinario(email, nome, senha);
                usuarios.add(novoVeterinario);
                System.out.println("Cadastro realizado com sucesso");
                rodando = false;
                return novoVeterinario;
            } catch (EmailInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (NomeInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (SenhaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
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
    }
}
