package br.pucminas.hackathon.services;

import java.util.HashMap;
import java.util.Map;
import br.pucminas.hackathon.model.Jurado;
import br.pucminas.hackathon.model.Projeto;

// banca avaliadora de um projeto.
public class Banca {
    private Projeto projetoAvaliado;
    private Map<Jurado, Integer> jurados; //usar map

    public Banca(Projeto projetoAvaliado) {
        this.projetoAvaliado = projetoAvaliado;
        this.jurados = new HashMap<>();
    }

    public void adicionarJurado(Jurado jurado) {
        // a nota será adicionada depois.
        this.jurados.put(jurado, null);
    }


    public void atribuirNota(Jurado jurado, int nota) {
        if (this.jurados.containsKey(jurado)) {
            this.jurados.put(jurado, nota);
        }
    }

    // calcula a média das notas
    public void calcularNotaFinal() {
        //
        if (jurados.isEmpty() || jurados.containsValue(null)) {
            System.out.println("A banca do projeto " + projetoAvaliado.getNome() + " ainda não atribuiu todas as notas.");
            return;
        }

        double soma = 0;
        for (Integer nota : jurados.values()) {
            soma += nota;
        }

        double media = soma / jurados.size();
        this.projetoAvaliado.setNotaFinal(media);
    }
}
