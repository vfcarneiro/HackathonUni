package br.pucminas.hackathon.model;


public class Instituicao {
    private String nome;

    public Instituicao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Instituicao [nome=" + nome + "]";
    }
}
