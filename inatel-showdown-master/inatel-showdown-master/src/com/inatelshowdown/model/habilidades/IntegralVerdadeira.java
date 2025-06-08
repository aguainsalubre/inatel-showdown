package com.inatelshowdown.model.habilidades;
import com.inatelshowdown.model.Habilidade;
import com.inatelshowdown.model.Professor;

public class IntegralVerdadeira extends Habilidade {
    public IntegralVerdadeira() {
        super("Integral Verdadeira", "Um ataque poderoso com 50% de chance de atordoar o oponente. Dano: 80, Acerto: 95%", 5, 80, 0.95);
    }

    @Override
    public void usar(Professor usuario, Professor alvo) {
        if (!temPp()) {
            System.out.println("Cálculo complexo demais! (PP esgotado)");
            return;
        }
        decrementarPp();
        System.out.println(usuario.getNome() + " usou " + getNome() + "!");

        double chanceAcerto = getAcerto() * usuario.getAcerto() * (1 - alvo.getEvasao());
        if (Math.random() <= chanceAcerto) {
            int danoReal = (int) (getDano() * usuario.getModificadorAtaque());
            alvo.receberDano(danoReal);
            if (Math.random() < 0.5) {
                System.out.println(alvo.getNome() + " ficou atordoado com a complexidade!");
                alvo.setAtordoado(true);
            }
        } else {
            System.out.println(usuario.getNome() + " errou o cálculo!");
        }
    }
}