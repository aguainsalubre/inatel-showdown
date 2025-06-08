package com.inatelshowdown.battle;

import com.inatelshowdown.model.Professor;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    private Professor jogador;
    private Professor inimigo;
    private Scanner scanner;
    private Random random = new Random();

    public Batalha(Professor jogador, Professor inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
        this.scanner = new Scanner(System.in);
    }

    private int escolherHabilidadeJogador() {
        int escolha;
        while (true) { // Loop até receber uma entrada válida
            System.out.print("Escolha uma habilidade: ");
            try {
                escolha = scanner.nextInt();
                if (escolha >= 0 && escolha < jogador.getHabilidades().size()) {
                    if (jogador.getHabilidades().get(escolha).temPp()) {
                        return escolha; // Retorna a escolha se for válida e tiver PP
                    } else {
                        System.out.println("Essa habilidade não tem PP suficiente!");
                    }
                } else {
                    System.out.println("Escolha inválida! Por favor, escolha um número da lista.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.next(); // Limpa o buffer do scanner para evitar loop infinito
            }
        }
    }

    private void executarTurno(Professor atacante, Professor defensor) {
        // Atualiza os efeitos de status do atacante no início do turno
        atacante.atualizarEfeitos();

        // Verifica status de atordoado no início do turno
        if (atacante.isAtordoado()) {
            System.out.println(atacante.getNome() + " está atordoado e não pode se mover!");
            atacante.setAtordoado(false); // Recupera-se do atordoamento no próximo turno
            return;
        }

        System.out.println("\n--- TURNO DE " + atacante.getNome().toUpperCase() + " ---");
        System.out.printf("HP: %d/%d | %s HP: %d/%d\n",
                jogador.getHp(), jogador.getHpMax(),
                inimigo.getNome(), inimigo.getHp(), inimigo.getHpMax());

        if (atacante == jogador) {
            jogador.listarHabilidades();
            int escolha = escolherHabilidadeJogador();
            jogador.usarHabilidade(escolha, defensor);
        } else {
            // IA Simples: escolhe uma habilidade aleatória que tenha PP
            int escolhaInimigo;
            do {
                escolhaInimigo = random.nextInt(atacante.getHabilidades().size());
            } while (!atacante.getHabilidades().get(escolhaInimigo).temPp());

            atacante.usarHabilidade(escolhaInimigo, defensor);
        }
    }

    public void iniciar() {
        System.out.println("\n======== A BATALHA COMEÇOU! ========");
        System.out.println(jogador.getNome() + " vs " + inimigo.getNome() + "\n");

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            executarTurno(jogador, inimigo);

            if (!inimigo.estaVivo()) break;

            executarTurno(inimigo, jogador);
        }

        System.out.println("\n======== FIM DA BATALHA! ========");
        if (jogador.estaVivo()) {
            System.out.println("🎉 Parabéns! " + jogador.getNome() + " venceu! 🎉");
        } else {
            System.out.println("☠️ " + jogador.getNome() + " foi derrotado! ☠️");
        }
    }
}