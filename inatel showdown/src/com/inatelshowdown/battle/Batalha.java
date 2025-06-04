package com.inatelshowdown.battle;

public class Batalha {
        private Professor jogador;
        private Professor inimigo;
        private Scanner scanner;

        public Batalha(Professor jogador, Professor inimigo) {
            this.jogador = jogador;
            this.inimigo = inimigo;
            this.scanner = new Scanner(System.in);
        }

        public void iniciar() {
            while (jogador.estaVivo() && inimigo.estaVivo()) {
                // Turno do jogador
                System.out.println("\n=== SEU TURNO ===");
                System.out.println("HP: " + jogador.getHp() + " | Inimigo HP: " + inimigo.getHp());
                System.out.println("Escolha uma habilidade:");
                for (int i = 0; i < jogador.getHabilidades().size(); i++) {
                    Habilidade hab = jogador.getHabilidades().get(i);
                    System.out.printf("%d - %s (PP: %d/%d)%n", i, hab.getNome(), hab.getPpAtual(), hab.getPpMax());
                }
                int escolha = scanner.nextInt();
                jogador.usarHabilidade(escolha, inimigo);

                // Turno do inimigo (IA simples: escolhe aleatório)
                if (inimigo.estaVivo()) {
                    System.out.println("\n=== TURNO DO INIMIGO ===");
                    int escolhaInimigo = (int) (Math.random() * inimigo.getHabilidades().size());
                    inimigo.usarHabilidade(escolhaInimigo, jogador);
                }
            }
            System.out.println(jogador.estaVivo() ? "\nVocê venceu!" : "\nVocê perdeu!");
        }
    }
}
