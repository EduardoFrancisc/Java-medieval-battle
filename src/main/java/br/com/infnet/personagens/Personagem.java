package br.com.infnet.personagens;

import br.com.infnet.util.DadoUtil;
import lombok.Getter;
import lombok.Setter;

public abstract class Personagem {

    @Getter@Setter
    private int pontosDeVida;
    @Getter
    private int forca;
    @Getter
    private int defesa;
    @Getter
    private int agilidade;
    @Getter
    private String nome;

    public Personagem(int pontosDeVida, int forca, int defesa, int agilidade, String nome){
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.nome = nome;
    }

    public int calcularIniciativa(){
        DadoUtil dado = new DadoUtil();
        return dado.rolarD10() + getAgilidade();
    }

    public int calcularFatorDeAtaque(){
        DadoUtil dado = new DadoUtil();
        return dado.rolarD10() + getAgilidade() + getForca();
    }

    public int calcularFatorDeDefesa(){
        DadoUtil dado = new DadoUtil();
        return dado.rolarD10() + getAgilidade() + getDefesa();
    }
    public abstract int calcularFatorDeDano();
}
