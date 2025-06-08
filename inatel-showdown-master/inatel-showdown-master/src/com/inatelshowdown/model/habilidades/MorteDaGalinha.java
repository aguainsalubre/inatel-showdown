package com.inatelshowdown.model.habilidades;
import com.inatelshowdown.model.Habilidade;
import com.inatelshowdown.model.Professor;

public class MorteDaGalinha extends Habilidade {
    public MorteDaGalinha() {
        super("A Morte da Galinha", "Um ataque devastador, mas com uma precisão muito baixa. Dano: 160, Acerto: 40%", 5, 160, 0.40);
    }
    @Override
    public void usar(Professor usuario, Professor alvo) {
        if (!temPp()) {
            System.out.println("PP esgotado!");
            return;
        }
        decrementarPp();
        System.out.println(usuario.getNome() + " usou o temível ataque: " + getNome() + "!");

        double chanceAcerto = getAcerto() * usuario.getAcerto() * (1 - alvo.getEvasao());
        if (Math.random() <= chanceAcerto) {
            int danoReal = (int) (getDano() * usuario.getModificadorAtaque());
            alvo.receberDano(danoReal);
        } else {
            System.out.println("A galinha sobreviveu! O ataque errou!");
        }
    }
}