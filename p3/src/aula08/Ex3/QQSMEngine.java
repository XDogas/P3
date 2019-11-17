package aula08.Ex3;

import static java.lang.System.err;
import static java.lang.System.exit;

import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class QQSMEngine {
	
	ArrayList<String> nivel1 = new ArrayList<String>();
	ArrayList<String> nivel2 = new ArrayList<String>();
	ArrayList<String> nivel3 = new ArrayList<String>();
	
	Premio premioAtual = Premio.VINTECINCO;
	
	JToggleButton correct;
	
	QQSMEngine() throws FileNotFoundException{
		
		File file = new File("src\\aula08\\Ex3\\questions.txt");
		Scanner scf = new Scanner(file);
		
		while(scf.hasNextLine()){
			String line = scf.nextLine();
			if(line.split("&&")[6].equals("0")) {
				nivel1.add(line);
			}
			else if(line.split("&&")[6].equals("1")) {
				nivel2.add(line);
			}
			else if(line.split("&&")[6].equals("2")) {
				nivel3.add(line);
			}
			else{
				err.println("Erro ao ler perguntas.");
				exit(0);
			}			
		}		
		scf.close();
	}
	
	public void getQuestion(JTextArea value, JLabel image, JTextArea question, JRadioButton op1, JRadioButton op2, JRadioButton op3, JRadioButton op4){
		
		String q;
		int rand;
		
		if(chooseDif() == 0){
			rand = getRanToN(nivel1.size());
			q = nivel1.get(rand);
		}
		else if(chooseDif() == 1){
			rand = getRanToN(nivel2.size());
			q = nivel2.get(rand);
		}
		else{
			rand = getRanToN(nivel3.size());
			q = nivel3.get(rand);
		}
		
		question.setText(q.split("&&")[1]);
		image.setIcon(new ImageIcon("src\\aula08\\Ex3\\imgs" + q.split("&&")[0]));
		value.setText(String.valueOf(getMoney())+"€");
		
		int[] arr = ranArrayn(4);
		op1.setText(q.split("&&")[arr[0]+2]);
		op2.setText(q.split("&&")[arr[1]+2]);
		op3.setText(q.split("&&")[arr[2]+2]);
		op4.setText(q.split("&&")[arr[3]+2]);
		
		int c = 0;
		for(int i=0; i<4; i++){
			if(arr[i] == 0) c = i;
		}
		
		switch(c){
			case 0:
				correct = op1;
				break;
			case 1:
				correct = op2;
				break;
			case 2:
				correct = op3;
				break;
			case 3:
				correct = op4;
				break;
		}
		
		if(chooseDif()==0){
			nivel1.remove(rand);
		}
		else if(chooseDif()==1){
			nivel2.remove(rand);
		}
		else{
			nivel3.remove(rand);
		}
	}
	
	public void play(Container contentPane, JTextArea money, JLabel image, JTextArea question, JToggleButton p1, JToggleButton p2, JToggleButton p3, JToggleButton p4){
		
		JToggleButton selected = null;
		
		if(p1.isSelected())	selected = p1;
		else if(p2.isSelected()) selected = p2;
		else if(p3.isSelected()) selected = p3;
		else if(p4.isSelected()) selected = p4;
		
		if(selected != correct){
			JOptionPane.showMessageDialog(contentPane, "Ganhou " + String.valueOf(getMoney()) + "€!" , "Fim do Jogo", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
			exit(0);
		}
		
		if(selected == correct && premioAtual.getValue() == 250000){
			JOptionPane.showMessageDialog(contentPane, "Ganhou 250.000€!!!", "Ganhou TUDO", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
			exit(0);
		}
		
		premioAtual = Premio.next(premioAtual);
	}
	
	public int getMoney(){
		return premioAtual.getValue();
	}

	

	public void ajudaPublico(Container c, JButton publico, JToggleButton p1, JToggleButton p2, JToggleButton p3, JToggleButton p4){
		
		int dif = chooseDif();		
		int max=(int)(Math.random()*100);
		
		int per=0;
		for(int i=0;i<(3-dif)*2;i++){
			per =(int)(Math.random()*100);
			if(per>max)
				max=per;
		}
		
		JToggleButton errado1 = new JToggleButton();
		JToggleButton errado2 = new JToggleButton();
		JToggleButton errado3 = new JToggleButton();
		
		if(correct == p1){
			errado2 = p2;
			errado3 = p3;
			errado1 = p4;
		}
		if(correct == p2){
			errado2 = p4;
			errado3 = p3;
			errado1 = p1;
		}
		if(correct == p3){
			errado2 = p2;
			errado3 = p1;
			errado1 = p4;
		}
		if(correct == p4){
			errado2 = p2;
			errado3 = p3;
			errado1 = p1;
		}
		
		int pr2=(100-max)/6;
		int pr3=2*(100-max)/6;
		int pr4=3*(100-max)/6;
		
		String s = "";
		
		int rand[] = ranArrayn(4);
		
		for(int i=0;i<4;i++){
			if(rand[i]==0){
				s += correct.getText()+": "+max+"%\n";
			}
			else if(rand[i]==1)
				s += errado2.getText()+": "+(pr2+1)+"%\n";
			else if(rand[i]==2)
				s += errado3.getText()+": "+pr3+"%\n";
			else 
				s += errado1.getText()+": "+pr4+"%\n";
		}
		
		JOptionPane.showMessageDialog(c, s, "Ajuda do Público", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
				
		publico.setEnabled(false);
		
	}
	
	public void telefone(Container content, JButton telefone, JToggleButton p1, JToggleButton p2, JToggleButton p3, JToggleButton p4){

		int dif = chooseDif();		
		int bnt =- 1;
		JToggleButton wrong = null;
		
		if(correct == p1)
			bnt = 0;
		else if(correct == p2)
			bnt = 1;
		else if(correct == p3)
			bnt = 2;
		else
			bnt=3;
		
		int randbotao = getRanToN(4);
		
		while(randbotao == bnt)
			randbotao = getRanToN(4);
		
		switch(randbotao){
			case 0:
				wrong = p1;
				break;
			case 1:
				wrong = p2;
				break;
			case 2:
				wrong = p3;
				break;
			case 3:
				wrong = p4;
				break;
		}
		
		int perErrada;
		int perCerta;
		perErrada = (int)(((Math.random())/(3-dif))*100);
		perCerta = 100 - perErrada;
		
		if(perCerta > perErrada)
			JOptionPane.showMessageDialog(content, "Duvida entre:\n" + correct.getText() + ": " + perCerta + "%\n" + wrong.getText()+": " + perErrada + "%", "Telefone", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
		else 
			JOptionPane.showMessageDialog(content, "Duvida entre:\n" + wrong.getText() + ": " + perErrada + "%\n" + correct.getText()+": " + perCerta + "%", "Telefone", JOptionPane.OK_OPTION|JOptionPane.INFORMATION_MESSAGE);
		
		telefone.setEnabled(false);
	}
	
	public void ff(JButton c, JToggleButton p1, JToggleButton p2, JToggleButton p3, JToggleButton p4){
		
		int except;
		if(correct == p1)
			except = 0;
		else if(correct == p2)
			except = 1;
		else if(correct == p3)
			except = 2;
		else
			except = 3;
		
		int[] ran = ranArrayn(4);
		
		int j = 0;
		for(int i=0; i<3; i++){
			
			if(ran[i] == 0 && except != 0){
				p1.setEnabled(false);
				j++;
			}
			else if(ran[i] == 1 && except != 1){
				p2.setEnabled(false);
				j++;
			}
			else if(ran[i] == 2 && except != 2){
				p3.setEnabled(false);
				j++;
			}
			else if(ran[i] == 3 && except != 3){
				p4.setEnabled(false);
				j++;
			}			
			if(j == 2) break;
		}
		c.setEnabled(false);
	}
	
	private int chooseDif(){
		if (premioAtual.getValue() <= 500) return 0;
		else if(premioAtual.getValue() <= 10000) return 1;
		else return 2;
	}
	
	private int getRanToN(int n){
		return (int) (Math.random()*n);
	}

	private int[] ranArrayn(int n){
		int[] arr = new int[n];
		int i = 0;
		while(i != n){
			int ran = getRanToN(n);
			boolean exists = false;
			for(int j=i-1; j>=0; j--){
				if(ran == arr[j]) exists = true;
			}
			if(!exists){
				arr[i] = ran;
				i++;
			}
			
		}
		return arr;
	}

}
