package br.com.infnet.batalha;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Gravacoes {
    static void Logs(String nickname, List<String> dados) {
        try {

            String corVerde = "\u001B[32m";
            String corReset = "\u001B[0m";

            Scanner in = new Scanner(System.in);
            String diretorio = "temp";
            Path dir = Paths.get(diretorio);

            if (!Files.exists(dir)) {
                Files.createDirectory(dir);
            }

            String filename = "temp/" + nickname + ".csv";
            Path path = Paths.get(filename);

            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {

                StringBuilder resultado = new StringBuilder();
                for (String item : dados) {
                    resultado.append(item).append(";");
                }

                // Remove o último ponto e vírgula, se houver
                if (resultado.length() > 0) {
                    resultado.setLength(resultado.length() - 1);
                }

                writer.println(resultado.toString());

                System.out.println("Dados adicionados ao arquivo CSV.");
                System.out.println("Aperte " + corVerde + "ENTER " + corReset + "para continuar...");
                in.nextLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }

    static void ExibirRelatorio(String nickname) {

        int mortoVivo = 0;
        int kobold = 0;
        int orc = 0;
        int guerreiro = 0;
        int barbaro = 0;
        int paladino = 0;
        int totalDePontos = 0;
        int vitorias = 0;

        String caminho = "temp/" + nickname + ".csv";

        List<Relatorio> dados = new ArrayList<>();

        try {

            String corVerde = "\u001B[32m";
            String corReset = "\u001B[0m";

            Scanner in = new Scanner(System.in);
            dados = Files.lines(Paths.get(caminho))
                    .skip(0)
                    .map(line -> {
                        String[] partes = line.split(";");
                        String data = partes[0].toString().trim();
                        String heroi = partes[1].toString().trim();
                        String status = partes[2].toString().trim();
                        String inimigo = partes[3].toString().trim();
                        String rodadas = partes[4];

                        return new Relatorio(data, heroi, status, inimigo, rodadas);
                    })
                    .collect(Collectors.toList());

            for (Relatorio dado : dados) {

                // quantos inimigos enfrentados
                if (dado.getInimigo().equals("Kobold")) {
                    kobold += 1;
                }
                if (dado.getInimigo().equals("Orc")) {
                    orc += 1;
                }
                if (dado.getInimigo().equals("Morto-Vivo")) {
                    mortoVivo += 1;
                }

                // quantas vezes cada heroi
                if (dado.getHeroi().equals("Bárbaro")) {
                    barbaro += 1;
                }
                if (dado.getHeroi().equals("Guerreiro")) {
                    guerreiro += 1;
                }
                if (dado.getHeroi().equals("Paladino")) {
                    paladino += 1;
                }

                // Pontos
                if (dado.getStatus().equals("Ganhou")) {
                    vitorias += 1;
                    totalDePontos += 100 - Integer.parseInt(dado.getRodadas());
                }
            }

            System.out.printf("QUANTAS VEZES ENFRENTOU CADA INIMIGO: \n Kobold: %d, Orc: %d, Morto-Vivo: %d", kobold,
                    orc, mortoVivo);
            System.out.printf("\nQUANTAS VEZES USOU CADA HERÓI: \n Bárbaro: %d  Guerreiro: %d, Paladino: %d", barbaro,
                    guerreiro, paladino);
            System.out.println("\n--------------------------");
            System.out.println("Total de vitórias: " + vitorias);
            System.out.println("Total de Pontos: " + totalDePontos);

            

        } catch (IOException e) {
            System.out.println("Não foi possivel localizar esse nickname");
        }
    }
}
