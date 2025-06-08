import com.inatelshowdown.battle.Batalha;
import com.inatelshowdown.model.Professor;
import com.inatelshowdown.model.Habilidade;
import com.inatelshowdown.model.habilidades.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // --- Criando o Pool de Habilidades Comuns ---
        Habilidade soco = new Soco();
        Habilidade rasteira = new Rasteira();
        Habilidade distracao = new Distracao();
        Habilidade arremessoCafe = new ArremessoDeCafe();
        Habilidade ataqueAlgoritmo = new AtaqueDeAlgoritmo();
        Habilidade intensivao = new Intensivao();

        // --- Criando Professores e suas Habilidades Especiais ---

        // Professor 1: Chris
        List<Habilidade> habilidadesChris = new ArrayList<>();
        habilidadesChris.add(new CarecaQueTudoReflete()); // Especial
        habilidadesChris.add(soco);
        habilidadesChris.add(distracao);
        Professor chris = new Professor("Chris", 120, habilidadesChris);

        // Professor 2: Renan
        List<Habilidade> habilidadesRenan = new ArrayList<>();
        habilidadesRenan.add(new IntegralVerdadeira()); // Especial
        habilidadesRenan.add(ataqueAlgoritmo);
        habilidadesRenan.add(soco);
        Professor renan = new Professor("Renan", 95, habilidadesRenan);

        // Professor 3: Luis Felipe
        List<Habilidade> habilidadesFelipe = new ArrayList<>();
        habilidadesFelipe.add(new MorteDaGalinha()); // Especial
        habilidadesFelipe.add(rasteira);
        habilidadesFelipe.add(arremessoCafe);
        Professor felipe = new Professor("Luis Felipe", 90, habilidadesFelipe);

        // Professor 4: Renzo
        List<Habilidade> habilidadesRenzo = new ArrayList<>();
        habilidadesRenzo.add(new PuloDoGato()); // Especial
        habilidadesRenzo.add(new AtaqueDiscreto()); // Outra especial
        habilidadesRenzo.add(intensivao);
        Professor renzo = new Professor("Renzo", 100, habilidadesRenzo);

        List<Professor> todosProfessores = new ArrayList<>();
        todosProfessores.add(chris);
        todosProfessores.add(renan);
        todosProfessores.add(felipe);
        todosProfessores.add(renzo);

        Scanner scanner = new Scanner(System.in);
        Professor jogador = null;
        Professor inimigo = null;

        System.out.println("Bem-vindo ao Inatel Showdown!");

        // --- Seleção do Jogador ---
        while (jogador == null) {
            System.out.println("\nEscolha o seu lutador:");
            for (int i = 0; i < todosProfessores.size(); i++) {
                System.out.println((i + 1) + " - " + todosProfessores.get(i).getNome());
            }
            System.out.print("Digite o número do professor para ver os status: ");

            try {
                int escolha = scanner.nextInt();
                if (escolha > 0 && escolha <= todosProfessores.size()) {
                    Professor professorEscolhido = todosProfessores.get(escolha - 1);
                    professorEscolhido.exibirStats();

                    System.out.print("\nDeseja escolher " + professorEscolhido.getNome() + "? (1 - Sim, 2 - Não): ");
                    int confirmacao = scanner.nextInt();
                    if (confirmacao == 1) {
                        jogador = professorEscolhido;
                    }
                } else {
                    System.out.println("Escolha inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.next(); // Limpa o buffer
            }
        }

        // --- Seleção do Inimigo ---
        List<Professor> oponentesDisponiveis = new ArrayList<>(todosProfessores);
        oponentesDisponiveis.remove(jogador);

        while (inimigo == null) {
            System.out.println("\nEscolha o seu oponente:");
            for (int i = 0; i < oponentesDisponiveis.size(); i++) {
                System.out.println((i + 1) + " - " + oponentesDisponiveis.get(i).getNome());
            }
            System.out.print("Digite o número do oponente: ");

            try {
                int escolha = scanner.nextInt();
                if (escolha > 0 && escolha <= oponentesDisponiveis.size()) {
                    Professor oponenteEscolhido = oponentesDisponiveis.get(escolha - 1);
                    oponenteEscolhido.exibirStats();
                    System.out.print("\nDeseja lutar contra " + oponenteEscolhido.getNome() + "? (1 - Sim, 2 - Não): ");
                    int confirmacao = scanner.nextInt();
                    if (confirmacao == 1) {
                        inimigo = oponenteEscolhido;
                    }

                } else {
                    System.out.println("Escolha inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.next(); // Limpa o buffer
            }
        }


        // --- Iniciando a Batalha ---
        Batalha batalha = new Batalha(jogador, inimigo);
        batalha.iniciar();

        scanner.close();
    }
}