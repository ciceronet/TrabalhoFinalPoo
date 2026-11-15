package service;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;
import ui.Entrada;

public class Contexto {
    public final ArrayList<Usuario> usuarios = new ArrayList<>();
    public final ArrayList<Voluntario> voluntarios = new ArrayList<>();
    public final ArrayList<Veterinario> veterinarios = new ArrayList<>();
    public final ArrayList<Animais> cadastrados = new ArrayList<>();
    public final ArrayList<Animais> adotados = new ArrayList<>();
    public final ArrayList<SolicitacaoAdocao> solicitacoes = new ArrayList<>();
    public final ArrayList<Notificacao> notificacoes = new ArrayList<>();
    
    public final AtividadeService atividadeService = new AtividadeService();
    public final ControleSaude controleSaude = new ControleSaude();
    public final Scanner sc = Entrada.SC;
}
