package aula08.Ex1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class TTTFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private TTTPanel panel;
	
	public TTTFrame() {
		super("Tic Tac Toe");
		
		this.setLayout(new BorderLayout());
		
		panel = new TTTPanel();
		
		this.add(panel, BorderLayout.CENTER);
		
		this.setMinimumSize(new Dimension(360,360));
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
