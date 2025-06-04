package com.inatelshowdown.model;

public class EfeitoConfusao extends EfeitoStatus {
    public EfeitoConfusao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public void aplicar(Professor alvo) {
        alvo.setModificadorAcerto(alvo.getModificadorAcerto() * 0.7); // Reduz 30%
        System.out.println(alvo.getNome() + " está confuso e erra mais!");
    }

    @Override
    public void remover(Professor alvo) {
        alvo.setModificadorAcerto(alvo.getModificadorAcerto() / 0.7);
        System.out.println(alvo.getNome() + " voltou ao normal!");
    }

    @Override
    public void atualizar(Professor alvo) {
        duracao--;
    }
}
}
