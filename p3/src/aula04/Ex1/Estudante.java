package aula04.Ex1;

import java.util.Calendar;

public class Estudante extends Pessoa {
	
	private static int nMecCounter = 100;
	private int nMec;
	private Data dataInsc;

	public Estudante(String nome, int cc, Data dataNasc, Data dataInsc) {
		super(nome, cc, dataNasc);
		this.nMec = nMecCounter++;
		this.dataInsc = dataInsc;
		
	}
	
	public Estudante(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
		this.nMec = nMecCounter++;
		Calendar hoje = Calendar.getInstance();
		this.dataInsc = new Data(hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, hoje.get(Calendar.YEAR));		//ou ... = Data.hoje();	
	}
	
	public int nMec() { return this.nMec; }
	public Data dataInsc() { return this.dataInsc; }
	
	@Override
	public String toString() {
		 return super.toString() + ", Estudante NMec: " + nMec() + ", Inscrito em Data: " + dataInsc().toString();
	}

}
