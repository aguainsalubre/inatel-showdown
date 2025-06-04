package com.inatelshowdown.model;

public class abstract EfeitoStatus  {

    private int duracao;

    public abstract void aplicar(Professor alvo);
    public abstract void remover(Professor alvo);
    public abstract void atualizar(Professor alvo);

    public boolean terminou() {
        return duracao <= 0;
    }

}
