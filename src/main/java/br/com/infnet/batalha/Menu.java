package br.com.infnet.batalha;

import br.com.infnet.personagens.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;


public class Menu {
    private static final Logger LOGGER = LoggerFactory.getLogger(Menu.class);
    public static void principal() {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        String nickname;
        String nickPesquisa;

        LOGGER.debug("Iniciando o Programa");

        while (true) {

            try {
                LOGGER.info("\nDeseja jogar ou Exibir um relatório? \n 1 - JOGAR \n 2 - Exibir um relatório \n 3 - Sair");

                int primeiraEscolha = in.nextInt();

                if (primeiraEscolha == 1) {

                    LOGGER.info("\nVocê escolheu Jogar. \n Qual seu Nickname?");

                    nickname = in.next();

                    LOGGER.info("\nQual Herói deseja ser? \n 1 - Guerreiro \n 2 - Bárbaro \n 3 - Paladino");

                    int userEscolha = in.nextInt();

                    Personagem userPersonagem;
                    Personagem enemyPersonagem=null;

                    switch (userEscolha) {
                        case 1:
                            LOGGER.info("\nHerói Guerreiro Selecionado");
                            userPersonagem = new Guerreiro();
                            break;
                        case 2:
                            LOGGER.info("\nHerói Bárbaro Selecionado");
                            userPersonagem = new Barbaro();
                            break;
                        case 3:
                            LOGGER.info("\nHerói Paladino Selecionado");
                            userPersonagem = new Paladino();
                            break;
                        default:
                            userPersonagem = new Guerreiro();
                            LOGGER.info("\nHerói Guerreiro selecionado por padrão.");
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

                    LOGGER.info("\nO " + userPersonagem.getNome() + " enfrentará o " + enemyPersonagem.getNome());
                    LOGGER.info("\nVida atual do " + userPersonagem.getNome() + ": " + userPersonagem.getPontosDeVida());
                    LOGGER.info("\nVida atual do " + enemyPersonagem.getNome() + ": " + enemyPersonagem.getPontosDeVida());


                    CampoDeBatalha.Batalha(nickname, enemyPersonagem, userPersonagem);
                }
                if (primeiraEscolha == 2) {
                    LOGGER.info("\nQual nick deseja Gerar um Relatório?");
                    nickPesquisa = in.next();
                    Gravacoes.ExibirRelatorio(nickPesquisa);
                }
                if (primeiraEscolha == 3) {
                    LOGGER.info("\nObrigado por Jogar!");
                    LOGGER.debug("\nPrograma Finalizado.");
                    break;
                }

            } catch (Exception e) {
                LOGGER.error("Entrada inválida " + e);
                break;
            }
        }

    }
}
