package br.com.infnet.batalha;

import br.com.infnet.personagens.*;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void principal() {

        Scanner in = new Scanner(System.in);
        Random random = new Random();
        String nickname;
        String nickPesquisa;

        while (true) {

            try {

                System.out.println("Deseja jogar ou Exibir um relatório? \n 1 - JOGAR \n 2 - Exibir um relatório \n 3 - Sair");
                int primeiraEscolha = in.nextInt();

                if (primeiraEscolha == 1) {

                    System.out.println("Você escolheu Jogar. \n Qual seu Nickname?");

                    nickname = in.next();

                    System.out.println("Qual Herói deseja ser? \n 1 - Guerreiro \n 2 - Bárbaro \n 3 - Paladino");

                    int userEscolha = in.nextInt();

                    Personagem userPersonagem = null;
                    Personagem enemyPersonagem = null;

                    switch (userEscolha) {
                        case 1:
                            System.out.println("Herói Guerreiro Selecionado");
                            userPersonagem = new Guerreiro();
                            break;
                        case 2:
                            System.out.println("Herói Bárbaro Selecionado");
                            userPersonagem = new Barbaro();
                            break;
                        case 3:
                            System.out.println("Herói Paladino Selecionado");
                            userPersonagem = new Paladino();
                            break;
                        default:
                            userPersonagem = new Guerreiro();
                            System.out.println("Herói Guerreiro selecionado por padrão.");
                            break;
                    }

                    int enemyEscolha = random.nextInt(3) + 1;

                    switch (enemyEscolha) {
                        case 1:
                            enemyPersonagem = new MortoVivo();
                            break;
                        case 2:
                            enemyPersonagem = new Orc();
                            break;
                        case 3:
                            enemyPersonagem = new Kobold();
                            break;
                    }

                    System.out.println("O " + userPersonagem.getNome() + " enfrentará o " + enemyPersonagem.getNome());
                    System.out.println("Vida atual do " + userPersonagem.getNome() + ": " + userPersonagem.getPontosDeVida());
                    System.out.println("Vida atual do " + enemyPersonagem.getNome() + ": " + enemyPersonagem.getPontosDeVida());


                    CampoDeBatalha.Batalha(nickname, enemyPersonagem, userPersonagem);
                }
                if (primeiraEscolha == 2) {
                    System.out.println("Qual nick deseja Gerar um Relatório?");
                    nickPesquisa = in.next();
                    Gravacoes.ExibirRelatorio(nickPesquisa);
                }
                if (primeiraEscolha == 3) {
                    System.out.println("Obrigado por Jogar!");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida " + e);
                break;
            }
        }

    }
}
