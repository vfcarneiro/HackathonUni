package br.pucminas.hackathon.model;

import java.time.LocalDateTime;
import br.pucminas.hackathon.services.*;

// evento de apresentação de um projeto.
public class Apresentacao implements Avaliavel {
    private Projeto projeto; //
    private Banca banca;     //
    private Sala local;      //
    private LocalDateTime dataHora; //

    public Apresentacao(Projeto projeto, Banca banca, Sala local, LocalDateTime dataHora) {
        this.projeto = projeto;
        this.banca = banca;
        this.local = local;
        this.dataHora = dataHora;
    }

    public Projeto getProjeto() {
        return projeto;
    }


    @Override
    public void avaliar() {
        System.out.println("Avaliando apresentação do projeto: " + projeto.getNome());
        banca.calcularNotaFinal();
        System.out.println("Avaliação concluída. Nota final: " + String.format("%.2f", projeto.getNotaFinal()));
    }
}