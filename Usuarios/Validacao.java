package Usuarios;

import java.util.Set;
import exceptions.*;
public class Validacao {
    private static final Set<String> DOMINIOS_ACEITOS = Set.of ("gmail.com", "outlook.com", "hotmail.com", "icloud.com", "yahoo.com");
    private Validacao() {}
    public static void validarEmail(String email) throws EmailInvalidoException {
        if (email == null || email.isBlank()) {
            throw new EmailInvalidoException("Erro! Email vazio!");
        }
        int posicaoArroba = email.indexOf('@');
        if (posicaoArroba <= 0) {
            throw new EmailInvalidoException("Erro! Digite algo antes do @!");
        }
        String dominio = email.substring(posicaoArroba + 1).toLowerCase();
        if (!DOMINIOS_ACEITOS.contains(dominio)) {
            throw new EmailInvalidoException("Erro! Digite um domínio válido!");
        }
    }
    public static void validarNome(String nome) {
        if(nome == null || nome.isBlank()) {
            throw new NomeInvalidoException("Erro! Nome Vazia!");
        }
        for(char c : nome.toCharArray()) {
            if(Character.isDigit(c)) {
                throw new NomeInvalidoException("Erro! Números não são permitidos no nome!");
            }
        }
    }
    public static void validarSenha(String senha) {
        if(senha == null || senha.isBlank()) {
            throw new SenhaInvalidaException("Erro! Senha Vazia!");
        }
        int tamanho = senha.length();
        if(tamanho < 7) {
            throw new SenhaInvalidaException("Erro! A senha precisa de no mínimo 8 caracteres!");
        }
    }
}
