package com.inatelshowdown.model;

public abstract  class EfeitoStatus {

    private int duracao;

    public abstract void aplicar(Professor alvo);
    public abstract void remover(Professor alvo);
    public abstract void atualizar(Professor alvo);

    public boolean terminou() {
        return duracao <= 0;
    }

    protected int getDuracao() {
        return duracao;
    }

    protected void setDuracao(int duracao) {
        this.duracao = duracao;
    }

}
