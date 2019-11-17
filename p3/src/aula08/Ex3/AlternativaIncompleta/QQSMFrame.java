package aula08.Ex3.AlternativaIncompleta;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class QQSMFrame extends JFrame {
	
	private TextPanel textPanel;
	private HelpPanel helpPanel;
	private OptionPanel optionPanel;
	private Question question;
	
	public QQSMFrame() throws IOException {
		super("Quem Quer Quer Milionário");
		this.setLayout(new BorderLayout());
		
		textPanel = new TextPanel();
		helpPanel = new HelpPanel();
		optionPanel = new OptionPanel();
		question = new Question("src//aula08//Ex3//Files//questions.txt");
		
		textPanel.appendText("Pergunta:\n" + question.getQuestion());
		
		this.add(textPanel, BorderLayout.CENTER);
//		this.add(helpPanel, BorderLayout.CENTER);
		this.add(optionPanel, BorderLayout.SOUTH);
		
		this.setSize(650,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	// Para a janela aparecer no centro do e
		this.setVisible(true);
		
	}

}
