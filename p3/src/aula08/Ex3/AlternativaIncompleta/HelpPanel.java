package aula08.Ex3.AlternativaIncompleta;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class HelpPanel extends JPanel {
	
	private JButton ajudaPublicoBTN;
	private JButton telefoneBTN;
	private JButton ffBTN;
	
	public HelpPanel() {
		ajudaPublicoBTN = new JButton("Ajuda Publico");
		telefoneBTN = new JButton("Telefone");
		ffBTN = new JButton("50-50");
		
		//System.out.print(ajudaPublicoBTN.getPreferredSize());	\\para descobrir o as dimensões do primeiro botão
		Dimension BTNdim = getPreferredSize();	// para todos os botões terem o tamanho do primeiro
		BTNdim.width = ajudaPublicoBTN.getPreferredSize().width;
		BTNdim.height = ajudaPublicoBTN.getPreferredSize().height;
		telefoneBTN.setPreferredSize(BTNdim);
		ffBTN.setPreferredSize(BTNdim);
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.add(ajudaPublicoBTN);
		this.add(telefoneBTN);
		this.add(ffBTN);
	}

}
