package aula04.Ex1;

import java.util.Calendar;

public class Professor extends Pessoa {
	
	private static int nfuncCounter = 1;
	private int nfunc;
	private Data dataAdmissao;

	public Professor(String nome, int cc, Data dataNasc, Data dataAdmissao) {
		super(nome, cc, dataNasc);
		this.nfunc = nfuncCounter++;
		this.dataAdmissao = dataAdmissao;
	}
	
	public Professor(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc);
		this.nfunc = nfuncCounter++;
		Calendar hoje = Calendar.getInstance();
		this.dataAdmissao = new Data(hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH)+1, hoje.get(Calendar.YEAR));		//ou ... = Data.hoje();	
	}
	
	public int getNfunc() { return this.nfunc; }
	public Data getDataAdmissao() { return this.dataAdmissao; }
	
	@Override
	public String toString() {
		return "PROFESSOR: " + super.toString() + ", NMec: " + getNfunc() + ", Admitido em Data: " + getDataAdmissao();
	}
	
	
	@Override
	public boolean equals(Object obj) {
			// Não é necessário testar a classe, feito em Pessoa
		if(!super.equals(obj)) return false;
		
		Professor other = (Professor)obj;		
			// Verifica se atributos do objeto são iguais
		if(this.nfunc != other.nfunc) return false;
		if(this.dataAdmissao == null && other.dataAdmissao != null) return false;
		else if(!dataAdmissao.equals(other.dataAdmissao))return false;		
		
		return true;		
	}

}
