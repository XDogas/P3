package aula08.Ex3;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class QQSMFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public QQSMFrame() throws IOException{
		super("Quem Quer Ser Milionário");
		
		QQSMEngine jogo = new QQSMEngine();
		
		
		JPanel content = new JPanel();
		content.setLayout(null);
		
		JTextArea money = new JTextArea();
		money.setBackground(content.getBackground());
		money.setFont(new Font("Arial", Font.PLAIN, 20));
		money.setBounds(900, 20, 100, 50);
		money.setEditable(false);
		
		JLabel image = new JLabel();
		image.setBounds(10, 5, 500, 390);
		
		JTextArea question = new JTextArea();
		question.setBackground(content.getBackground());
		question.setBounds(600, 90, 300, 300);
		question.setFont(new Font("Arial", Font.PLAIN, 30));
		question.setEditable(false);
		question.setWrapStyleWord(true);
		question.setLineWrap(true);
		
		JButton publico = new JButton("Ajuda público");
		publico.setBounds(10, 400, 150, 35);
		
		
		JButton telefone = new JButton("Telefone...");
		telefone.setBounds(190, 400, 150, 35);
		
		
		JButton cinquenta = new JButton("50 - 50");
		cinquenta.setBounds(370, 400, 150, 35);
		
		
		JButton desistir = new JButton("Desistir");
		desistir.setBounds(630, 500, 150, 35);
		desistir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getContentPane(), "Ganhou " + String.valueOf(jogo.getMoney()) + "€!");
				System.exit(0);
			}
			
		});
		
		ButtonGroup perguntas = new ButtonGroup();
		
		JRadioButton p1=new JRadioButton();
		JRadioButton p2=new JRadioButton();
		JRadioButton p3=new JRadioButton();
		JRadioButton p4=new JRadioButton();

		perguntas.add(p1);
		perguntas.add(p2);
		perguntas.add(p3);
		perguntas.add(p4);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(800, 500, 150, 35);
		confirmar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.play(getContentPane(), money, image, question, p1, p2, p3, p4);
				perguntas.clearSelection();
				p1.setEnabled(true);
				p2.setEnabled(true);
				p3.setEnabled(true);
				p4.setEnabled(true);
				jogo.getQuestion(money, image, question, p1, p2, p3, p4);
			}
			
		});
		
		cinquenta.addActionListener(e ->
			jogo.ff(cinquenta, p1,p2,p3,p4)
		);
		
		publico.addActionListener(e ->
			jogo.ajudaPublico(getContentPane(), publico, p1,p2,p3,p4)
		);
		
		telefone.addActionListener(e ->
			jogo.telefone(getContentPane(), telefone, p1,p2,p3,p4)
		);
		
		p1.setBounds(30,450,200,50);
		p2.setBounds(30,500,200,50);
		p3.setBounds(300,450,200,50);
		p4.setBounds(300,500,200,50);
		
		content.add(money);
		content.add(image);
		content.add(question);
		content.add(publico);
		content.add(telefone);
		content.add(cinquenta);
		content.add(p1);
		content.add(p2);
		content.add(p3);
		content.add(p4);
		content.add(desistir);
		content.add(confirmar);
		jogo.getQuestion(money, image, question, p1, p2, p3, p4);
		add(content);
		
		this.setMinimumSize(new Dimension(1000,600));
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
