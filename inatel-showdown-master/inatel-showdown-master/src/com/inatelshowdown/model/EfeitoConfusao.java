package com.inatelshowdown.model;

public class EfeitoConfusao extends EfeitoStatus {

    public EfeitoConfusao(int duracao) {
        super.setDuracao(duracao);
    }

    @Override
    public void aplicar(Professor alvo) {
        // Acessa o acerto através dos getters e setters
        alvo.setAcerto(alvo.getAcerto() * 0.7); // Reduz 30%
        System.out.println(alvo.getNome() + " está confuso e seu acerto diminuiu!");
    }

    @Override
    public void remover(Professor alvo) {
        alvo.setAcerto(alvo.getAcerto() / 0.7); // Restaura o acerto
        System.out.println(alvo.getNome() + " não está mais confuso!");
    }

    @Override
    public void atualizar(Professor alvo) {
        super.setDuracao(super.getDuracao() - 1); // Reduz a duração
        if (!terminou()) {
            System.out.println(alvo.getNome() + " continua confuso...");
        }
    }
}