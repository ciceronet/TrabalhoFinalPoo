package service;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Set;
import exceptions.*;
public final class Validacao {
    Scanner scan = new Scanner(System.in);
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

    public static void validarNome(String nome) throws NomeInvalidoException{
        if(nome == null || nome.isBlank()) {
            throw new NomeInvalidoException("Erro! Nome Vazia!");
        }
        for(char c : nome.toCharArray()) {
            if(Character.isDigit(c)) {
                throw new NomeInvalidoException("Erro! Números não são permitidos no nome!");
            }
        }
    }

    public static void validarSenha(String senha) throws SenhaInvalidaException{
        if(senha == null || senha.isBlank()) {
            throw new SenhaInvalidaException("Erro! Senha Vazia!");
        }
        int tamanho = senha.length();
        if(tamanho < 8) {
            throw new SenhaInvalidaException("Erro! A senha precisa de no mínimo 8 caracteres!");
        }
    }
    

    public static void validarIdade(int idade) throws IdadeInvalidaException {
        if (idade < 0 || idade > 30) {
            throw new IdadeInvalidaException("Erro! Idade Inválida! A idade deve estar entre 0 e 30 anos.");
        }
    }

    public static void validarTarefa(String nome) throws AtividadeException{
        if(nome == null || nome.isBlank()) {
            throw new AtividadeException("Erro! Título vazio!");
        }
    }

    public static void validarVagas(int vagas) throws AtividadeException{
        if (vagas <= 0) {
            throw new AtividadeException("Erro! Número de vagas precisa ser maior que 0!");
        }
    }

    public static void validarDataResgate(LocalDate data) throws AtividadeException{
        if(data == null || data.isAfter(LocalDate.now())) {
            throw new AtividadeException("Erro! Data está no futuro!");
        }
    }

    public static void validarDataAtividade(LocalDate data) throws AtividadeException{
        if(data == null || data.isBefore(LocalDate.now())) {
            throw new AtividadeException("Erro! Data está no passado!");
        }
    }
    
}
    
    
