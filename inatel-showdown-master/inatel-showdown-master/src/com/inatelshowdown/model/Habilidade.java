package com.inatelshowdown.model;

public abstract class Habilidade {
    private String nome;
    private String descricao; // descrição da habilidade
    private int ppMax; // quantidade de vezes que uma habilidade pode ser usada
    private int ppAtual; // quantidade de vezes restantes que uma habilidade pode ser usada
    private int dano;
    private double acerto; // Acerto base da habilidade (0.0 a 1.0)

    public Habilidade(String nome, String descricao, int ppMax, int dano, double acerto) {
        this.nome = nome;
        this.descricao = descricao;
        this.ppMax = ppMax;
        this.ppAtual = ppMax;
        this.dano = dano;
        this.acerto = acerto;
    }

    //Metodo abstrato que será implementado por cada habilidade específica
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
    public String getDescricao() { return descricao; }
    public int getPpAtual() { return ppAtual; }
    public int getPpMax() { return ppMax; }
    public int getDano() { return dano; }
    public double getAcerto() { return acerto; }
}