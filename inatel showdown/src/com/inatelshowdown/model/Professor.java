package com.inatelshowdown.model;

import java.util.List;

public class Professor {
    private String nome;
    private int hp;
    private int velocidade;          // Define ordem de ataque
    private double modificadorAcerto; // 1.0 = 100% de acerto
    private List<Habilidade> habilidades;
    private List<EfeitoStatus> efeitosAtivos;

    // Construtor
    public Professor(String nome, int hp, int velocidade, List<Habilidade> habilidades) {
        this.nome = nome;
        this.hp = hp;
        this.velocidade = velocidade;
        this.modificadorAcerto = 1.0;
        this.habilidades = habilidades;
        this.efeitosAtivos = new ArrayList<>();
    }

    // Aplica um efeito de status (ex: reduzir acerto)
    public void aplicarEfeito(EfeitoStatus efeito) {
        efeitosAtivos.add(efeito);
        efeito.aplicar(this);
    }

    // Atualiza efeitos no fim do turno
    public void atualizarEfeitos() {
        Iterator<EfeitoStatus> it = efeitosAtivos.iterator();
        while (it.hasNext()) {
            EfeitoStatus efeito = it.next();
            efeito.atualizar(this);
            if (efeito.terminou()) {
                it.remove();
                efeito.remover(this);
            }
        }
    }

    // Getters & Setters
    public double getModificadorAcerto() { return modificadorAcerto; }
    public void setModificadorAcerto(double valor) { this.modificadorAcerto = valor; }
    public int getVelocidade() { return velocidade; }
    public void setVelocidade(int valor) { this.velocidade = valor; }
}