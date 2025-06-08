package com.inatelshowdown.model.habilidades;
import com.inatelshowdown.model.Habilidade;
import com.inatelshowdown.model.Professor;

public class PuloDoGato extends Habilidade {
    public PuloDoGato() {
        super("O Pulo do Gato", "Aumenta o dano dos ataques do usuário em 50%. Bônus de Ataque: +50%", 10, 0, 1.0);
    }

    @Override
    public void usar(Professor usuario, Professor alvo) {
        if (!temPp()) {
            System.out.println("PP esgotado!");
            return;
        }
        decrementarPp();
        System.out.println(usuario.getNome() + " usou " + getNome() + "!");

        double novoModificador = usuario.getModificadorAtaque() * 1.5;
        usuario.setModificadorAtaque(Math.min(novoModificador, 3.0));
        System.out.println(usuario.getNome() + " está mais ágil e seu ataque aumentou!");
    }
}