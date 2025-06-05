package com.inatelshowdown.model;

import java.util.List;

public class Professor {
    private String nome;
    private int hp;
    private List<Habilidade> habilidades;
    private double acerto = 1.0;

    public Professor(String nome, int hp, List<Habilidade> habilidades) {
        this.nome = nome;
        this.hp = hp;
        this.habilidades = habilidades;
    }

    // Métodos necessários para a Batalha
    public boolean estaVivo() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void usarHabilidade(int index, Professor alvo) {
        Habilidade hab = habilidades.get(index);
        hab.usar();
        System.out.println(nome + " usou " + hab.getNome() + " em " + alvo.nome + "!");
    }

    public void receberDano(int dano) {
        hp -= dano;
        if (hp < 0) hp = 0;
    }

    public String getNome() {
        return nome;
    }

    public void listarHabilidades() {
        System.out.println("Habilidades de " + nome + ":");
        for (int i = 0; i < habilidades.size(); i++) {
            Habilidade hab = habilidades.get(i);
            System.out.printf("%d - %s (PP: %d/%d)%n",
                    i, hab.getNome(), hab.getPpAtual(), hab.getPpMax());
        }

    }

    public void aprenderHabilidade(Habilidade hab) {
        if (habilidades.size() < 4) {
            habilidades.add(hab);
            System.out.println(nome + " aprendeu " + hab.getNome() + "!");
        } else {
            System.out.println("Limite de habilidades atingido!");
        }
    }

    public void usarHabilidadeUnica(int index, Professor alvo) {
        Habilidade hab = habilidades.get(index);
        hab.usar();
        System.out.println(nome + " usou " + hab.getNome() + " em " + alvo.nome + "!");

    }

}