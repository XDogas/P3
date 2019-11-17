import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class JogoDoGalo extends JFrame
{
    public static void main(final String[] array) {
        final JogoDoGalo jogoDoGalo = new JogoDoGalo();
        jogoDoGalo.setDefaultCloseOperation(3);
        jogoDoGalo.setVisible(true);
        Botao.iniciaJogadorX(array.length == 0 || !array[0].equalsIgnoreCase("O"));
    }
    
    public JogoDoGalo() {
        this.setLocationByPlatform(true);
        this.setSize(210, 210);
        this.setTitle("Jogo do Galo");
        final Tabuleiro tabuleiro = new Tabuleiro(this);
        final JPanel comp = new JPanel();
        comp.setLayout(new GridLayout(3, 3));
        for (int i = 1; i <= 3; ++i) {
            for (int j = 1; j <= 3; ++j) {
                comp.add(new Botao(i, j, tabuleiro));
            }
        }
        this.add(comp, "Center");
    }
    
    public void notificaFim(final int n) {
        assert n >= -1 && n <= 1;
        JOptionPane.showMessageDialog(this.getContentPane(), "Resultado: " + (new String[] { "venceu jogador O", "empate", "venceu jogador X" })[n + 1]);
        System.exit(0);
    }
}
