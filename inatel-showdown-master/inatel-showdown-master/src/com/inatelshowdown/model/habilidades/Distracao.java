package com.inatelshowdown.model.habilidades;
import com.inatelshowdown.model.Habilidade;
import com.inatelshowdown.model.Professor;

public class Distracao extends Habilidade {
    public Distracao() {
        super("Distração", "Distrai o oponente, diminuindo seu acerto. Acerto do Alvo: -10%", 20, 0, 1.0);
    }

    @Override
    public void usar(Professor usuario, Professor alvo) {
        if (!temPp()) {
            System.out.println("PP esgotado!");
            return;
        }
        decrementarPp();
        System.out.println(usuario.getNome() + " usou " + getNome() + "!");

        double novoAcerto = alvo.getAcerto() - 0.10;
        alvo.setAcerto(Math.max(novoAcerto, 0.50));
        System.out.println("O acerto de " + alvo.getNome() + " diminuiu!");
    }
}