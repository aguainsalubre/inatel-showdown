public class Habilidade {
    private String nome;
    private int ppMax;   // Power Points (usos máximos)
    private int ppAtual;
    private int danoBase;

    public Habilidade(String nome, int ppMax, int danoBase) {
        this.nome = nome;
        this.ppMax = ppMax;
        this.ppAtual = ppMax;
        this.danoBase = danoBase;
    }

    // Calcula dano (pode ser sobrescrito para habilidades especiais)
    public int calcularDano() {
        return danoBase;
    }

    // Getters
    public void decrementarPp() { ppAtual--; }
    public int getPpAtual() { return ppAtual; }
    public String getNome() { return nome; }
}
