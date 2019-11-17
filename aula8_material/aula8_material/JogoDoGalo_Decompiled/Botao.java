import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

// 
// Decompiled by Procyon v0.5.36
// 

public class Botao extends JToggleButton implements ActionListener
{
    protected Tabuleiro tab;
    protected int lin;
    protected int col;
    protected static boolean jogadorX;
    
    public Botao(final int lin, final int col, final Tabuleiro tab) {
        super("");
        this.addActionListener(this);
        this.lin = lin;
        this.col = col;
        this.tab = tab;
        this.setFont(new Font("Helvetica", 1, 40));
    }
    
    public void actionPerformed(final ActionEvent actionEvent) {
        if (Botao.jogadorX) {
            this.setText("X");
        }
        else {
            this.setText("O");
        }
        this.setEnabled(false);
        this.tab.joga(this.lin, this.col, Botao.jogadorX);
        Botao.jogadorX = !Botao.jogadorX;
    }
    
    public static void iniciaJogadorX(final boolean jogadorX) {
        Botao.jogadorX = jogadorX;
    }
}
