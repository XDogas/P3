package aula08.Ex1;

import static java.lang.System.exit;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TTTPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton btn[][];
	private int countPlays;
	static Player player;
	
	
	public TTTPanel() {
		this.setLayout(new GridLayout(3,3));
		
		btn = new JButton[3][3];		
		countPlays = 0;

		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				this.add(btn[i][j] = new JButton());
				
				btn[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton)e.getSource();
						btn.setFont(new Font("Arial", 1, 100));
						if(player == Player.X) {
							btn.setText("X");
							btn.setEnabled(false);
							player = Player.O;
						}
						else {
							btn.setText("O");
							btn.setEnabled(false);
							player = Player.X;
						}
						
						countPlays++;
						
						verifyWinner();
					}
				});
				
			}
		}
		
	}

	public void verifyWinner() {
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				// Verificar se O ganhou
				if(btn[0][0].getText().equals("O") && btn[0][1].getText().equals("O") && btn[0][2].getText().equals("O")) end("O");		// 1ª linha
				else if(btn[1][0].getText().equals("O") && btn[1][1].getText().equals("O") && btn[1][2].getText().equals("O")) end("O");	// 2ª linha
				else if(btn[2][0].getText().equals("O") && btn[2][1].getText().equals("O") && btn[2][2].getText().equals("O")) end("O");	// "O"ª linha
				else if(btn[0][0].getText().equals("O") && btn[1][0].getText().equals("O") && btn[2][0].getText().equals("O")) end("O");	// 1ª coluna
				else if(btn[0][1].getText().equals("O") && btn[1][1].getText().equals("O") && btn[2][1].getText().equals("O")) end("O");	// 2ª coluna
				else if(btn[0][2].getText().equals("O") && btn[1][2].getText().equals("O") && btn[2][2].getText().equals("O")) end("O");	// "O"ª coluna 
				else if(btn[0][0].getText().equals("O") && btn[1][1].getText().equals("O") && btn[2][2].getText().equals("O")) end("O");	// diagonal (\)
				else if(btn[0][2].getText().equals("O") && btn[1][1].getText().equals("O") && btn[2][0].getText().equals("O")) end("O");	// diagonal (/)
				// Verificar se X ganhou
				else if(btn[0][0].getText().equals("X") && btn[0][1].getText().equals("X") && btn[0][2].getText().equals("X")) end("X"); // 1ª linha
				else if(btn[1][0].getText().equals("X") && btn[1][1].getText().equals("X") && btn[1][2].getText().equals("X")) end("X"); // 2ª linha
				else if(btn[2][0].getText().equals("X") && btn[2][1].getText().equals("X") && btn[2][2].getText().equals("X")) end("X"); // "O"ª linha
				else if(btn[0][0].getText().equals("X") && btn[1][0].getText().equals("X") && btn[2][0].getText().equals("X")) end("X"); // 1ª coluna
				else if(btn[0][1].getText().equals("X") && btn[1][1].getText().equals("X") && btn[2][1].getText().equals("X")) end("X"); // 2ª coluna
				else if(btn[0][2].getText().equals("X") && btn[1][2].getText().equals("X") && btn[2][2].getText().equals("X")) end("X"); // "O"ª coluna
				else if(btn[0][0].getText().equals("X") && btn[1][1].getText().equals("X") && btn[2][2].getText().equals("X")) end("X"); // diagonal (\)
				else if(btn[0][2].getText().equals("X") && btn[1][1].getText().equals("X") && btn[2][0].getText().equals("X")) end("X"); // diagonal (/)
			}			
		}
		// Verificar empate, caso com 9 jogadas ninguem ter ganho
		if (countPlays == 9 ) end("T");
	}

	private void end(String p) {
		if(p.equals("T")) {
			JOptionPane.showMessageDialog(TTTPanel.this, "empate", "Resultado", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
			exit(0);
		} else if(p.equals("X")) {
			JOptionPane.showMessageDialog(TTTPanel.this, "venceu jogador X", "Resultado", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
			exit(0);
		} else if(p.equals("O")) {
			JOptionPane.showMessageDialog(TTTPanel.this, "venceu jogador O", "Resultado", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
			exit(0);
		}		
	}

}