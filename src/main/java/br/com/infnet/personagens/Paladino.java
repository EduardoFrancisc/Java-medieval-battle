package br.com.infnet.personagens;

import br.com.infnet.util.DadoUtil;

public class Paladino extends Personagem{
    public Paladino() {
        super(15, 2, 5, 1, "Paladino");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dado = new DadoUtil();
        return dado.rolarD4() + dado.rolarD4();
    }
}
