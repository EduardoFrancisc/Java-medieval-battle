package br.com.infnet.personagens;

import br.com.infnet.util.DadoUtil;

public class Barbaro extends Personagem{
    public Barbaro() {
        super(13, 6, 1, 3, "Barbaro");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dado = new DadoUtil();
        return dado.rolarD6() + dado.rolarD6();
    }
}
