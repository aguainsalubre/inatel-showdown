package com.inatelshowdown.model.habilidades;
import com.inatelshowdown.model.Habilidade;
import com.inatelshowdown.model.Professor;

public class AtaqueDeAlgoritmo extends Habilidade {
    public AtaqueDeAlgoritmo() {
        super("Ataque de Algoritmo", "Usa um algoritmo complexo que causa dano e diminui a evasão do oponente. Dano: 20, Acerto: 100%", 15, 20, 1.0);
    }

    @Override
    public void usar(Professor usuario, Professor alvo) {
        if (!temPp()) {
            System.out.println("PP esgotado!");
            return;
        }
        decrementarPp();
        System.out.println(usuario.getNome() + " usou " + getNome() + "!");

        int danoReal = (int) (getDano() * usuario.getModificadorAtaque());
        alvo.receberDano(danoReal);

        double novaEvasao = alvo.getEvasao() - 0.20;
        alvo.setEvasao(Math.max(novaEvasao, 0.0));
        System.out.println("A evasão de " + alvo.getNome() + " diminuiu!");
    }
}