package Lab03;

public class Posicao implements Comparable<Posicao> {

    private int linha;
    private int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    @Override
    public int compareTo(Posicao outra) {
        if (this.linha != outra.linha) {
            return Integer.compare(this.linha, outra.linha);
        }
        return Integer.compare(this.coluna, outra.coluna);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Posicao)) {
            return false;
        }
        Posicao outra = (Posicao) obj;
        return this.linha == outra.linha && this.coluna == outra.coluna;
    }
}
