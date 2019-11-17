package aula08.Ex3.AlternativaIncompleta;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;	

public class OptionPanel extends JPanel {
	
	private JRadioButton op1;
	private JRadioButton op2;
	private JRadioButton op3;
	private JRadioButton op4;
	private JButton giveUp;
	private JButton confirm;
	private ButtonGroup bgroup;
	
	public OptionPanel() {
		op1 = new JRadioButton("op1");
		op2 = new JRadioButton("op2");
		op3 = new JRadioButton("op3");
		op4 = new JRadioButton("op4");
		bgroup = new ButtonGroup();	    
	    // Set up radios
		bgroup.add(op1);
	    bgroup.add(op2);
	    bgroup.add(op3);
	    bgroup.add(op4);
	    //
	    
		giveUp = new JButton("Desistir");
		confirm = new JButton("Confirmar");		
		
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// Primeira linha
		
		gc.weightx = 1;		// comprimento da primeira linha á escala
		gc.weighty = 1;		// altura da primeira linha á escala
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		this.add(op1, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		this.add(op2, gc);
		
		// Segunda linha
		
		gc.weightx = 1;		// comprimento da segunda linha á escala
		gc.weighty = 1;		// altura da segunda linha á escala
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		this.add(op3, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		this.add(op4, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.CENTER;
		this.add(giveUp, gc);
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,1,0,0);
		this.add(confirm, gc);

		
		
	}

}
