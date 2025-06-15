package br.pucminas.hackathon.services;

import br.pucminas.hackathon.model.Apresentacao;
import br.pucminas.hackathon.model.Projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Apresentacoes {
    private static Apresentacoes instancia;
    private List<Apresentacao> listaDeApresentacoes;

    private Apresentacoes() {
        listaDeApresentacoes = new ArrayList<>();
    }

    public static synchronized Apresentacoes getInstance() {
        if (instancia == null) {
            instancia = new Apresentacoes();
        }
        return instancia;
    }


    public void adicionarApresentacao(Apresentacao apresentacao) {
        this.listaDeApresentacoes.add(apresentacao);
    }

    public List<Projeto> getProjetosAprovados() {
        return listaDeApresentacoes.stream()
                .map(Apresentacao::getProjeto)
                .filter(projeto -> projeto.getNotaFinal() >= 7)
                .collect(Collectors.toList());
    }
}