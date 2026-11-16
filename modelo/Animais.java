package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import exceptions.*;
import service.Validacao;
import ui.Entrada;
import ui.Selecao;
import ui.TelaPrincipal;

public class Animais {
    public static final String DISPONIVEL = "Disponível";
    public static final String ADOTADO = "Adotado";
    public static final String CRITICO = "Crítico";

    private static int contadorId = 0;

    private final int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte = "Não informado";
    private LocalDate dataResgate;
    private String status;
    private String estadoSaude;
    private final HistoricoMedico historicoMedico = new HistoricoMedico();

    public Animais(int id, String nome, String especie, String raca, int idade, LocalDate dataResgate, String status, String estadoSaude) throws NomeInvalidoException, IdadeInvalidaException{
        contadorId++;
        this.id = contadorId;
        setNome(nome);
        setIdade(idade);
        this.especie = especie;
        this.raca = raca;
        this.dataResgate = dataResgate;
        this.status = DISPONIVEL;
        this.estadoSaude = estadoSaude;
    }

    public int getId(){
        return id; 
    }
    public String getNome(){ 
        return nome; 
    }
    public String getEspecie(){ 
        return especie; 
    }
    public String getRaca(){ 
        return raca; 
    }
    public int getIdade(){ 
        return idade; 
    }
    public String getPorte(){ 
        return porte; 
    }
    public LocalDate getDataResgate(){ 
        return dataResgate;
    }
    public String getStatus(){ 
        return status; 
    }
    public String getEstadoSaude(){ 
        return estadoSaude; 
    }
    public HistoricoMedico getHistoricoMedico(){ 
        return historicoMedico; 
    }

    public void setNome(String nome) throws NomeInvalidoException{
        Validacao.validarNome(nome);
        this.nome = nome.trim();
    }
    public void setIdade(int idade) throws IdadeInvalidaException{
        Validacao.validarIdade(idade);
        this.idade = idade;
    }
    public void setEspecie(String especie) { 
    this.especie = especie; 
    }
    public void setRaca(String raca) { 
    this.raca = raca; 
    }
    public void setPorte(String porte) { 
    this.porte = porte; 
    }
    public void setDataResgate(LocalDate dataResgate) { 
    this.dataResgate = dataResgate; 
    }
    public void setStatus(String status) { 
    this.status = status; 
    }
    public void setEstadoSaude(String estadoSaude) { 
    this.estadoSaude = estadoSaude; 
    }

    public boolean podeSerAdotado(){
        return status.equalsIgnoreCase(DISPONIVEL) && !estadoSaude.equalsIgnoreCase(CRITICO);
    }

    @Override
    public String toString(){
        return "ID: " + id + " \n Nome: " + nome + " \n Espécie: " + especie + " \n Raça: " + raca + " \n Idade: " + idade + " \n Porte: " + porte + " \n Resgate: " + dataResgate + " \n Status: " + status + " \n Saúde: " + estadoSaude;
    }

    private static String escolherRaca(String especie){
        return especie.equalsIgnoreCase("Cachorro") ? Selecao.RacaCachorro() : Selecao.RacaGato();
    }

    public static void cadastrarAnimal(ArrayList<Animais> animais, Scanner sc){
        System.out.println("\n      CADASTRAR ANIMAL     ");
        try {
            System.out.print("Digite o nome: ");
            String nome = Entrada.lerLinha();
            Validacao.validarNome(nome);

            String especie = Selecao.selecionarEspecie(sc);
            String raca = escolherRaca(especie);

            System.out.print("Digite a idade: ");
            int idade = Entrada.lerInt();
            Validacao.validarIdade(idade);

            String porte = Selecao.SelecionarPorte();

            LocalDate dataResgate = TelaPrincipal.lerData("Data de resgate");
            Validacao.validarDataResgate(dataResgate);

            String estadoSaude = Selecao.selecionarSaude();

            Animais novo = new Animais(0, nome, especie, raca, idade, dataResgate, DISPONIVEL, estadoSaude);
            novo.setPorte(porte);
            animais.add(novo);
            System.out.println("\nAnimal cadastrado com sucesso! ID: " + novo.getId());
        } catch (NomeInvalidoException | IdadeInvalidaException | AtividadeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void gerenciarAnimal(ArrayList<Animais> animais, Scanner sc){
        if (animais.isEmpty()){
            System.out.println("Não existem animais cadastrados.");
            return;
        }
        Animais encontrado = null;
        System.out.println("\n     BUSCAR ANIMAL     ");
        System.out.println("1 - Buscar por ID");
        System.out.println("2 - Buscar por Nome");
        System.out.print("Escolha: ");
        int busca = Entrada.lerInt();
        if (busca == 1){
            System.out.print("Digite o ID: ");
            int id = Entrada.lerInt();
            for (Animais a : animais) {
                if (a.getId() == id) { 
                    encontrado = a; break; 
                }
            }
        } else if (busca == 2){
            System.out.print("Digite o nome: ");
            String nome = Entrada.lerLinha();
            for (Animais a : animais) {
                if (a.getNome().equalsIgnoreCase(nome)) { 
                    encontrado = a; break; 
                }
            }
        } else {
            System.out.println("Opção inválida!");
            return;
        }
        if (encontrado == null){
            System.out.println("Animal não encontrado!");
            return;
        }

        System.out.println("\nAnimal encontrado:\n" + encontrado);
        System.out.println("\n     GERENCIAR ANIMAL     ");
        System.out.println("1 - Excluir");
        System.out.println("2 - Editar");
        System.out.print("Escolha: ");
        int opcao = Entrada.lerInt();

        if (opcao == 1){
            animais.remove(encontrado);
            System.out.println("Animal excluído com sucesso!");
        } else if (opcao == 2){
            editar(encontrado, sc);
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void editar(Animais a, Scanner sc){
        int editar = -1;
        while (editar != 0){
            System.out.println("\n      EDITAR ANIMAL       ");
            System.out.println("1 - Nome");
            System.out.println("2 - Espécie (e raça)");
            System.out.println("3 - Raça");
            System.out.println("4 - Idade");
            System.out.println("5 - Data de resgate");
            System.out.println("6 - Porte");
            System.out.println("0 - Finalizar edição");
            System.out.print("Escolha: ");
            editar = Entrada.lerInt();
            try {
                switch (editar){
                    case 1:
                        System.out.print("Novo nome: ");
                        a.setNome(Entrada.lerLinha());
                        break;
                    case 2:
                        a.setEspecie(Selecao.selecionarEspecie(sc));
                        a.setRaca(escolherRaca(a.getEspecie()));
                        break;
                    case 3:
                        a.setRaca(escolherRaca(a.getEspecie()));
                        break;
                    case 4:
                        System.out.print("Nova idade: ");
                        a.setIdade(Entrada.lerInt());
                        break;
                    case 5:
                        LocalDate data = TelaPrincipal.lerData("Nova data de resgate");
                        Validacao.validarDataResgate(data);
                        a.setDataResgate(data);
                        break;
                    case 6:
                        a.setPorte(Selecao.SelecionarPorte());
                        break;
                    case 0:
                        System.out.println("Edição finalizada!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NomeInvalidoException | IdadeInvalidaException | AtividadeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String semAcento(String texto){
        if (texto == null) return "";
        String n = java.text.Normalizer.normalize(texto, java.text.Normalizer.Form.NFD);
        return n.replaceAll("\\p{M}", "").toLowerCase().trim();
    }

    private static void filtrar(ArrayList<Animais> lista, java.util.function.Predicate<Animais> condicao){
        boolean achou = false;
        for (Animais a : lista){
            if (condicao.test(a)){
                System.out.println(a);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum animal encontrado.");
        }
    }

    public static void filtroAnimais(ArrayList<Animais> animais){
        int resposta = -1;
        while (resposta != 0){
            System.out.println("\n     BUSCAR / FILTRAR ANIMAIS     ");
            System.out.println("1 - Nome");
            System.out.println("2 - Espécie");
            System.out.println("3 - Raça");
            System.out.println("4 - Idade");
            System.out.println("5 - Porte");
            System.out.println("6 - Status");
            System.out.println("7 - Estado de saúde");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            resposta = Entrada.lerInt();
            if (resposta == 6){
                System.out.println("1 - " + DISPONIVEL);
                System.out.println("2 - " + ADOTADO);
                System.out.print("Escolha o status: ");
                int op = Entrada.lerInt();
                if (op == 1) {
                    filtrar(animais, a -> a.getStatus().equals(DISPONIVEL));
                } else if (op == 2) {
                    filtrar(animais, a -> a.getStatus().equals(ADOTADO));
                } else {
                    System.out.println("Opção inválida!");
                }
            } else if (resposta >= 1 && resposta <= 7 && resposta != 4){
                System.out.print("Digite o termo da busca: ");
                String termo = semAcento(Entrada.lerLinha());
                switch (resposta) {
                    case 1:
                        filtrar(animais, a -> semAcento(a.getNome()).contains(termo));
                        break;
                    case 2:
                        filtrar(animais, a -> semAcento(a.getEspecie()).contains(termo));
                        break;
                    case 3:
                        filtrar(animais, a -> semAcento(a.getRaca()).contains(termo));
                        break;
                    case 5:
                        filtrar(animais, a -> semAcento(a.getPorte()).contains(termo));
                        break;
                    default:
                        filtrar(animais, a -> semAcento(a.getEstadoSaude()).contains(termo));
                        break;
                }
            } else if (resposta == 4){
                System.out.print("Digite a idade: ");
                int idade = Entrada.lerInt();
                filtrar(animais, a -> a.getIdade() == idade);
            } else if (resposta != 0){
                System.out.println("Opção inválida!");
            }
        }
    }
}
