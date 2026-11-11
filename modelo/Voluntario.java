package modelo;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.*;
public class Voluntario extends Usuario{
        private ArrayList<Atividade> participacao = new ArrayList<>();
    public Voluntario (String email, String nome, String senha) throws EmailInvalidoException, NomeInvalidoException, SenhaInvalidaException {
        super(email, nome, senha);
    }
    public void registrarParticipacao(Atividade atividade) throws AtividadeException {
        if(atividade == null) {
            throw new AtividadeException("Atividade inválida!");
        }
        participacao.add(atividade);
    }
    public ArrayList<Atividade> getParticipacao() {
        return new ArrayList<>(participacao);
    }
    @Override 
    public void Menu() {
        Scanner scan = new Scanner(System.in);
        int resposta =0;
        boolean rodando = true;
            System.out.println("1 - Visualizar animais disponíveis para adoção");
            System.out.println("2 - Candidatar-se para atividade de apoio");
            System.out.println("3 - Animais sob sua responsabilidade");
            System.out.println("4 - Histórico de participações em ONG");
            while(rodando) {
                System.out.println("Selecione a opção que deseja");
                resposta = scan.nextInt();
            }
            switch (resposta) {
                case 1:
                
                    break;
                
                default:
                    break;
            }
        }
    }

