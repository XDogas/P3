package aula08.Ex3.AlternativaIncompleta;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	
	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea();
		
		this.setLayout(new BorderLayout());
		
		this.add(new JScrollPane(textArea), BorderLayout.CENTER);
		textArea.setEditable(false);
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}
}
