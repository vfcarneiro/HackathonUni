package br.pucminas.hackathon.services;

import br.pucminas.hackathon.model.Equipe;
import java.util.ArrayList;
import java.util.List;

public class Equipes {
    private static Equipes instancia;
    private List<Equipe> listaDeEquipes;

    private Equipes() {
        listaDeEquipes = new ArrayList<>();
    }

    public static synchronized Equipes getInstance() {
        if (instancia == null) {
            instancia = new Equipes();
        }
        return instancia;
    }

    // o metódo deve aceitar um objeto Equipe
    public void adicionarEquipe(Equipe equipe) {
        this.listaDeEquipes.add(equipe);
    }

    public List<Equipe> getListaDeEquipes() {
        return listaDeEquipes;
    }
}