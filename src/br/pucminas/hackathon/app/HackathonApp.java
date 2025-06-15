package br.pucminas.hackathon.app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.pucminas.hackathon.model.*;
import br.pucminas.hackathon.services.*;


// classe para simular o gerenciamento do Hackathon.
public class HackathonApp {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Gerenciamento do Hackathon ---");

        // criação de instituições
        Universidade pucMinas = new Universidade("PUC Minas");
        Empresa google = new Empresa("Google");
        Empresa oracle = new Empresa("Oracle");

        // criação de pessoas
        Profissional orientador1 = new Profissional("Prof. Daniel", pucMinas);
        Profissional orientador2 = new Profissional("Prof. Ana", pucMinas);

        List<Jurado> jurados = new ArrayList<>();
        jurados.add(new Jurado("Jurado A", google));
        jurados.add(new Jurado("Jurado B", oracle));
        jurados.add(new Jurado("Jurado C", google));
        jurados.add(new Jurado("Jurado D", oracle));

        // cria 2 equipes com 5 alunos cada
        System.out.println("\n--- Criando Equipes ---");
        Equipes equipesManager = Equipes.getInstance();

        Equipe equipe1 = new Equipe("DevsDeFerro");
        for (int i = 1; i <= 5; i++) {
            equipe1.adicionarMembro(new Estudante("Aluno " + i, pucMinas));
        }
        equipesManager.adicionarEquipe(equipe1);
        System.out.println("Equipe 'DevsDeFerro' criada com 5 membros.");

        Equipe equipe2 = new Equipe("CodeCrushers");
        for (int i = 6; i <= 10; i++) {
            equipe2.adicionarMembro(new Estudante("Aluno " + i, pucMinas));
        }
        equipesManager.adicionarEquipe(equipe2);
        System.out.println("Equipe 'CodeCrushers' criada com 5 membros.");

        // adiciona um projeto diferente para cada equipe
        System.out.println("\n--- Criando Projetos ---");
        Projeto projeto1 = new Projeto("Sistema de Gestão de Biblioteca", orientador1, equipe1);
        Projeto projeto2 = new Projeto("App de Caronas Universitárias", orientador2, equipe2);
        System.out.println("Projeto '" + projeto1.getNome() + "' atribuído à equipe " + equipe1.getNome());
        System.out.println("Projeto '" + projeto2.getNome() + "' atribuído à equipe " + equipe2.getNome());

        // criação de uma banca de avaliação cada projeto (com 4 jurados)
        System.out.println("\n--- Montando as Bancas ---");
        Banca banca1 = new Banca(projeto1);
        jurados.forEach(banca1::adicionarJurado);
        System.out.println("Banca para o projeto '" + projeto1.getNome() + "' criada com 4 jurados.");

        Banca banca2 = new Banca(projeto2);
        jurados.forEach(banca2::adicionarJurado);
        System.out.println("Banca para o projeto '" + projeto2.getNome() + "' criada com 4 jurados.");

        // simulação de apresentações
        Apresentacoes apresentacoesManager = Apresentacoes.getInstance();
        Sala sala = new Sala("101", "Prédio 3");

        Apresentacao ap1 = new Apresentacao(projeto1, banca1, sala, LocalDateTime.now());
        apresentacoesManager.adicionarApresentacao(ap1);

        Apresentacao ap2 = new Apresentacao(projeto2, banca2, sala, LocalDateTime.now().plusHours(1));
        apresentacoesManager.adicionarApresentacao(ap2);

        // calcular a nota final de cada projeto
        System.out.println("\n--- Fase de Avaliações ---");
        // projeto 1
        banca1.atribuirNota(jurados.get(0), 8);
        banca1.atribuirNota(jurados.get(1), 7);
        banca1.atribuirNota(jurados.get(2), 9);
        banca1.atribuirNota(jurados.get(3), 8);
        ap1.avaliar();

        //  projeto 2
        banca2.atribuirNota(jurados.get(0), 6);
        banca2.atribuirNota(jurados.get(1), 7);
        banca2.atribuirNota(jurados.get(2), 5);
        banca2.atribuirNota(jurados.get(3), 6);
        ap2.avaliar(); // mudar

        // lista os projetos com nota final >= 7
        System.out.println("\n--- Resultado Final: Projetos Aprovados (Nota >= 7) ---");
        List<Projeto> aprovados = apresentacoesManager.getProjetosAprovados();

        if (aprovados.isEmpty()) {
            System.out.println("Nenhum projeto foi aprovado.");
        } else {
            aprovados.forEach(System.out::println);
        }

        System.out.println("\n--- Fim da Simulação ---");
    }
}
