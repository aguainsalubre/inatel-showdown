package com.inatelshowdown.model.habilidades;
import com.inatelshowdown.model.Habilidade;
import com.inatelshowdown.model.Professor;

public class CarecaQueTudoReflete extends Habilidade {
    public CarecaQueTudoReflete() {
        super("Careca que Tudo Reflete", "Aumenta a evasão do usuário e diminui o acerto do oponente. Evasão: +20%, Acerto do Alvo: -15%", 10, 0, 1.0);
    }

    @Override
    public void usar(Professor usuario, Professor alvo) {
        if (!temPp()) {
            System.out.println("Sem polimento suficiente! (PP esgotado)");
            return;
        }
        decrementarPp();
        System.out.println(usuario.getNome() + " usou " + getNome() + "!");

        double novaEvasao = usuario.getEvasao() + 0.20;
        usuario.setEvasao(Math.min(novaEvasao, 0.75));
        System.out.println("O reflexo aumentou a evasão de " + usuario.getNome() + "!");

        double novoAcertoAlvo = alvo.getAcerto() - 0.15;
        alvo.setAcerto(Math.max(novoAcertoAlvo, 0.50));
        System.out.println("O brilho diminuiu o acerto de " + alvo.getNome() + "!");
    }
}