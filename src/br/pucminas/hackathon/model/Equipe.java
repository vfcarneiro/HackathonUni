package br.pucminas.hackathon.model;

import java.util.ArrayList;
import java.util.List;

// representa uma equipe de estudantes.
public class Equipe {
    private String nome;
    private List<Estudante> membros; //

    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Estudante estudante) {
        this.membros.add(estudante);
    }

    public String getNome() {
        return nome;
    }

    public List<Estudante> getMembros() {
        return membros;
    }
}
