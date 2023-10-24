package br.com.infnet.personagens;

import br.com.infnet.util.DadoUtil;

public class Kobold extends Personagem{
    public Kobold() {
        super(20, 4, 2, 4, "Kobold");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dado = new DadoUtil();
        return dado.rolarD2() + dado.rolarD2() + dado.rolarD2();
    }
}
