package com.inatelshowdown.model.habilidades;
import com.inatelshowdown.model.Habilidade;
import com.inatelshowdown.model.Professor;

public class AtaqueDiscreto extends Habilidade {
    public AtaqueDiscreto() {
        super("Ataque Discreto", "Um ataque poderoso, porém com baixa precisão. Dano: 110, Acerto: 70%", 15, 110, 0.70);
    }

    @Override
    public void usar(Professor usuario, Professor alvo) {
        if (!temPp()) {
            System.out.println("PP esgotado!");
            return;
        }
        decrementarPp();
        System.out.println(usuario.getNome() + " usou " + getNome() + "!");

        double chanceAcerto = getAcerto() * usuario.getAcerto() * (1 - alvo.getEvasao());
        if (Math.random() <= chanceAcerto) {
            int danoReal = (int) (getDano() * usuario.getModificadorAtaque());
            alvo.receberDano(danoReal);
        } else {
            System.out.println("O ataque foi discreto demais e errou!");
        }
    }
}