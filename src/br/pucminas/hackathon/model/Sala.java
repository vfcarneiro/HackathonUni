package br.pucminas.hackathon.model;

//  local da apresentação.
public class Sala {
    private String nome;
    private String bloco;

    public Sala(String nome, String bloco) {
        this.nome = nome;
        this.bloco = bloco;
    }

    @Override
    public String toString() {
        return "Sala " + nome + " (Bloco " + bloco + ")";
    }
}
