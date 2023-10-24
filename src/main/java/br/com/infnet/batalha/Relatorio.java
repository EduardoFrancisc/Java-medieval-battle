package br.com.infnet.batalha;

public class Relatorio {
    private String data;
    private String heroi;
    private String status;
    private String inimigo;
    private String rodadas;

    public Relatorio(String data, String heroi, String status, String inimigo, String rodadas) {
        this.data = data;
        this.heroi = heroi;
        this.status = status;
        this.inimigo = inimigo;
        this.rodadas = rodadas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHeroi() {
        return heroi;
    }

    public void setHeroi(String heroi) {
        this.heroi = heroi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInimigo() {
        return inimigo;
    }

    public void setInimigo(String inimigo) {
        this.inimigo = inimigo;
    }

    public String getRodadas() {
        return rodadas;
    }

    public void setRodadas(String rodadas) {
        this.rodadas = rodadas;
    }

}
