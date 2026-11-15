package service;

import exceptions.*;
import modelo.*;
import ui.Entrada;

public class UsuarioService {

    private interface Validador{
        void validar(String texto) throws Exception;
    }

    private UsuarioService(){
    }

    private static String ler(String pergunta, Validador validador){
        while (true) {
            System.out.print(pergunta);
            String texto = Entrada.lerLinha();
            try {
                validador.validar(texto);
                return texto;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Usuario cadastrar(Contexto ctx){
        System.out.println("\n      CADASTRO      ");
        System.out.println("1 - Voluntário");
        System.out.println("2 - Veterinário");
        System.out.println("0 - Voltar");
        System.out.print("Escolha: ");
        int tipo = Entrada.lerInt();
        if (tipo != 1 && tipo != 2){
            if (tipo != 0){
                System.out.println("Opção inválida!");
            }
            return null;
        }

        String email = ler("Digite seu email: ", texto -> {
            Validacao.validarEmail(texto);
            for (Usuario u : ctx.usuarios) {
                if (u.getEmail().equalsIgnoreCase(texto.trim())){
                    throw new UsuarioDuplicadoException("Erro! Já existe um usuário com este e-mail!");
                }
            }
        });
        String nome = ler("Digite seu nome: ", Validacao::validarNome);
        String senha = ler("Digite a senha (mínimo 8 caracteres): ", Validacao::validarSenha);

        try {
            if (tipo == 1){
                Voluntario v = new Voluntario(email, nome, senha);
                ctx.voluntarios.add(v);
                ctx.usuarios.add(v);
                System.out.println("Cadastro de voluntário realizado com sucesso!");
                return v;
            }
            Veterinario v = new Veterinario(email, nome, senha);
            ctx.veterinarios.add(v);
            ctx.usuarios.add(v);
            System.out.println("Cadastro de veterinário realizado com sucesso!");
            return v;
        } catch (EmailInvalidoException | NomeInvalidoException | SenhaInvalidaException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Usuario login(Contexto ctx){
        System.out.println("\n      LOGIN      ");
        System.out.print("Email: ");
        String email = Entrada.lerLinha();
        System.out.print("Senha: ");
        String senha = Entrada.lerLinha();
        for (Usuario u : ctx.usuarios) {
            if (u.getEmail().equalsIgnoreCase(email) && u.autenticar(senha)){
                System.out.println("Login realizado com sucesso! Bem-vindo(a), " + u.getNome() + ".");
                return u;
            }
        }
        System.out.println("Email ou senha incorretos.");
        return null;
    }
}
