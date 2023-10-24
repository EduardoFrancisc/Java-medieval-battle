package br.com.infnet.personagens;

import br.com.infnet.util.DadoUtil;

public class MortoVivo extends Personagem{
    public MortoVivo() {
        super(25, 4, 2, 4, "Morto Vivo");
    }

    @Override
    public int calcularFatorDeDano() {
        DadoUtil dado = new DadoUtil();
        return dado.rolarD4() + dado.rolarD4();
    }
}
