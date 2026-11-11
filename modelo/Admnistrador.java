package modelo;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.*;

public class Admnistrador extends Usuario{
      public Admnistrador(String email, String nome, String senha) throws EmailInvalidoException, SenhaInvalidaException, NomeInvalidoException {
        super(email, nome, senha);
    }
    int contador=0;
    Scanner scanner = new Scanner(System.in);
    @SuppressWarnings("unused")
    @Override 
    public void Menu(ArrayList<Animais> cadastrados , ArrayList<Animais> adotados , ArrayList<Animais> tratando ,ArrayList<Voluntario> voluntarios , ArrayList<Veterinario> veterinarios,ArrayList<Atividade> eventos) {
        
        boolean rodando = true;
        int resposta;
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Editar animal");
        System.out.println("3 - Remover Animal");
        System.out.println("4 - Solicitações de adoção");
        System.out.println("5 - Gerenciar Usuarios");
        System.out.println("6 - Notificações");
        System.out.println("7 - relatórios");
        System.out.println("8 - Estatisticas");
        while(rodando) {
            System.out.println("Selecione a opção desejada");
            resposta = scanner.nextInt();
            switch (resposta) {
                case 1:

                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                int opcao=scanner.nextInt();
                System.out.println("1 - Animias Resgatados");
                System.out.println("2 - Adoçoes realizadas");
                System.out.println("3 - Animais em tratamento");
                System.out.println("4 - Voluntarios Ativos");
                System.out.println("5 - Eventos Realizados");
                switch (opcao) {
                    case 1:
                    for (Animais u : cadastrados) {
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Porte:"+u.getPorte()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                }
                        break;
                    case 2:
                    for (Animais u : adotados) {
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Porte:"+u.getPorte()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                }
                        break;
                    case 3:
                    for (Animais u : tratando) {
                        System.out.print("Nome:"+u.getNome()+" ");
                        System.out.print("Especie:"+u.getEspecie()+" ");
                        System.out.print("Raca:"+u.getRaca()+" ");
                        System.out.print("Idade:"+u.getIdade()+" ");
                        System.out.print("Porte:"+u.getPorte()+" ");
                        System.out.print("Data de Resgate:"+u.getDataResgate()+" ");
                        System.out.print("Status:"+u.getStatus()+" ");
                        System.out.println();
                }
                        break;
                    case 4:
                    for (Voluntario u : voluntarios) {
                        System.out.print("Nome do Voluntario:"+u.getNome()+" ");
                        System.out.print("Email:"+u.getEmail()+" ");
                        System.out.println();
                }
                        break;
                    case 5:
                    for (Atividade u : eventos) {
                        System.out.print("Nome do evento:"+u.getTipo()+" ");
                        System.out.print("Data do evento:"+u.getData()+" ");
                        System.out.print("Vagas:"+u.getVagas()+" ");
                        System.out.println();
                }
                        break;
                    default:
                        break;
                }
                    break;
                case 8:
                    int contador=0;
                    int taxa = 0;
                for(Animais u : cadastrados){
                    contador++;
                }
                System.out.println("Animais cadastrados:"+contador);
                for(Animais u:adotados){
                    taxa++;
                }
                taxa=(taxa*100)/contador;
                System.out.println("Animais adotados:"+contador);
                contador=0;
                for(Animais u:tratando){
                    contador++;
                }
                System.out.println("Animais em tratamento:"+contador);
                contador=0;
                for(Voluntario u:voluntarios){
                    contador++;
                }
                System.out.println("Animais em tratamento:"+contador);
                contador=0;
                for(Voluntario u:voluntarios){
                    contador++;
                }
                System.out.println("Voluntários Ativos:"+contador);
                contador=0;
                for(Veterinario u:veterinarios){
                    contador++;
                }
                System.out.println("Veterinarios Ativos:"+contador);
                System.out.println("");
                System.out.println("Taxa de adoção:"+taxa);
                    break;
                default:
                    break;
            }
        }

    }
    @Override
    public String getTipoUsuario() {
        throw new UnsupportedOperationException("Unimplemented method 'getTipoUsuario'");
    }
}
