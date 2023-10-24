package br.com.infnet.personagens;

import br.com.infnet.util.DadoUtil;

public class Guerreiro extends Personagem{

    public Guerreiro() {
        super(12, 4, 3, 3, "Guerreiro");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dado = new DadoUtil();
        return dado.rolarD4() + dado.rolarD4();
    }
}
