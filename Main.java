import exceptions.*;
import modelo.*;
import service.Contexto;
import service.UsuarioService;
import ui.Entrada;

public class Main {
    public static void main(String[] args) {
        Contexto ctx = new Contexto();

        try {
            Admnistrador admin = new Admnistrador("admin@gmail.com", "Administrador", "admin1234");
            ctx.usuarios.add(admin);
        } catch (EmailInvalidoException | NomeInvalidoException | SenhaInvalidaException e) {
            System.out.println("Erro ao criar o administrador: " + e.getMessage());
            return;
        }

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=====  SISTEMA DE ABRIGO E RESGATE DE ANIMAIS  =====");
            System.out.println("1 - Entrar (login)");
            System.out.println("2 - Cadastrar-se");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            switch (Entrada.lerInt()) {
                case 1:
                    Usuario logado = UsuarioService.login(ctx);
                    if (logado != null) {
                        logado.Menu(ctx);
                    }
                    break;
                case 2:
                    UsuarioService.cadastrar(ctx);
                    break;
                case 0:
                    rodando = false;
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
