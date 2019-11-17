import javax.swing.JPanel;

// 
// Decompiled by Procyon v0.5.36
// 

public class Tabuleiro extends JPanel
{
    protected JogoDoGalo jogo;
    protected int[][] mapa;
    protected int numeroJogadas;
    protected int[] soma;
    protected int vencedor;
    
    public Tabuleiro(final JogoDoGalo jogo) {
        this.mapa = new int[3][3];
        this.numeroJogadas = 0;
        this.soma = new int[8];
        this.vencedor = 0;
        this.jogo = jogo;
    }
    
    public boolean posicaoValida(final int n, final int n2) {
        return n >= 1 && n <= 3 && n2 >= 1 && n2 <= 3;
    }
    
    public boolean posicaoVazia(final int n, final int n2) {
        assert this.posicaoValida(n, n2);
        return this.mapa[n - 1][n2 - 1] == 0;
    }
    
    public void joga(final int n, final int n2, final boolean b) {
        assert this.posicaoValida(n, n2) && this.posicaoVazia(n, n2);
        int n3;
        if (b) {
            n3 = 1;
        }
        else {
            n3 = -1;
        }
        this.mapa[n - 1][n2 - 1] = n3;
        ++this.numeroJogadas;
        final int[] soma = this.soma;
        final int n4 = n - 1;
        soma[n4] += n3;
        final int[] soma2 = this.soma;
        final int n5 = 3 + n2 - 1;
        soma2[n5] += n3;
        if (n == n2) {
            final int[] soma3 = this.soma;
            final int n6 = 6;
            soma3[n6] += n3;
        }
        if (n == 4 - n2) {
            final int[] soma4 = this.soma;
            final int n7 = 7;
            soma4[n7] += n3;
        }
        if (this.terminado()) {
            this.jogo.notificaFim(this.resultado());
        }
    }
    
    public boolean terminado() {
        boolean b = this.numeroJogadas == 9;
        for (int n = 0; !b && n < 8; b = (Math.abs(this.soma[n]) == 3), ++n) {}
        return b;
    }
    
    public int resultado() {
        assert this.terminado();
        int n = 0;
        for (int n2 = 0; n == 0 && n2 < 8; ++n2) {
            if (this.soma[n2] == 3) {
                n = 1;
            }
            else if (this.soma[n2] == -3) {
                n = -1;
            }
        }
        return n;
    }
}
