package br.com.infnet.personagens;

import br.com.infnet.util.DadoUtil;

public class Orc extends Personagem{
    public Orc() {
        super(20, 6, 2, 2, "Orc");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dado = new DadoUtil();
        return dado.rolarD8();
    }
}
