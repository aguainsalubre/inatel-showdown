package com.inatelshowdown.model;
import com.inatelshowdown.model.Professor;

public class EfeitoConfusao extends EfeitoStatus {

    public EfeitoConfusao(int duracao) {
        super.setDuracao(duracao);  // Acessa duracao via método protegido
    }

    @Override
    public void aplicar(Professor alvo) {
        // Adiciona métodos necessários na classe Professor
        alvo.setAcerto(alvo.getAcerto() * 0.7); // Reduz 30%
        System.out.println(alvo.getNome() + " está confuso e erra mais!");
    }

    @Override
    public void remover(Professor alvo) {
        alvo.setAcerto(alvo.getAcerto() / 0.7);
        System.out.println(alvo.getNome() + " voltou ao normal!");
    }

    @Override
    public void atualizar(Professor alvo) {
        super.setDuracao(super.getDuracao() - 1); // Atualiza duração
    }
}
