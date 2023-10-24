package br.com.infnet.util;

public class DadoUtil {
    private static int Rolar(int faces) {
        return (int) Math.round(Math.random() * faces);
    }

    public static int RolarD10() {
        return Rolar(10);
    }

    public int rolarD10() {
        return Rolar(10);
    }

    public int rolarD4() {
        return Rolar(4);
    }

    public int rolarD6() {
        return Rolar(6);
    }

    public int rolarD8() {
        return Rolar(8);
    }

    public int rolarD2() {
        return Rolar(2);
    }
}
