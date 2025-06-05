package com.inatelshowdown.model;

public abstract class Habilidade {
    private String nome;
    private int ppMax;
    private int ppAtual;
    private int dano;       // Novo atributo
    private double acerto;  // Novo atributo (0.0 a 1.0)

    public Habilidade(String nome, int ppMax, int dano, double acerto) {
        this.nome = nome;
        this.ppMax = ppMax;
        this.ppAtual = ppMax;
        this.dano = dano;
        this.acerto = acerto;
    }

    // Método abstrato (todas as habilidades devem implementar)
    public abstract void usar(Professor usuario, Professor alvo);

    // Métodos comuns
    public void decrementarPp() {
        if (ppAtual > 0) ppAtual--;
    }

    public boolean temPp() {
        return ppAtual > 0;
    }

    // Getters
    public String getNome() { return nome; }
    public int getPpAtual() { return ppAtual; }
    public int getPpMax() { return ppMax; }
    public int getDano() { return dano; }
    public double getAcerto() { return acerto; }
}