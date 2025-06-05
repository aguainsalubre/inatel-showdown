package com.inatelshowdown.model;

public class Soco extends Habilidade {

    public Soco(String nome, int ppMax, int dano, double acerto){
        super("Soco", 5, 5, 1.0);
    }

    @Override
    public void usar(Professor usuario, Professor alvo) {
        if (!temPp()) {
            System.out.println("PP esgotado de " + getNome() + "!");
            return;
        }

    }
}
