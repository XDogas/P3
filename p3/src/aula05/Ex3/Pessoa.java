package aula05.Ex3;

import java.util.Calendar;

public class Pessoa {
	
	protected String nome;
	protected int cc;
	protected Data dataNasc;
	
	public Pessoa(String nome, int cc, Data dataNasc) {
		assert nomeValido(nome) : "Nome inválido";
		assert ccValido(cc) : "cc inválido";
		
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
	}
	
	public String getNome() { return this.nome; }
	public int getCC() { return this.cc; }
	public Data getDataNasc() { return this.dataNasc; }
	
	public static boolean nomeValido(String nome) {
		return nome.length() > 0;
	}
	
	public static boolean ccValido(int cc) {
		return cc >= 0;
	}
	
	public int getIdade(){
		Calendar todayDate = Calendar.getInstance();
		int idade = todayDate.get(Calendar.YEAR) - this.dataNasc.getAno();
	    if (this.dataNasc.getMes() > todayDate.get(Calendar.MONTH) + 1 || (this.dataNasc.getMes() == todayDate.get(Calendar.MONTH) + 1 && this.dataNasc.getDia() > todayDate.get(Calendar.DAY_OF_MONTH))) {
	        idade--;
	    }
	    return idade;
	}
	
	@Override
	public String toString() {
		 return getNome() + ", BI: " + getCC() + ", Nascido na Data: " + getDataNasc().toString();
	}
	
	@Override
	public boolean equals(Object obj) {
			// Testa a class
		if(obj == null) return false;	
		if(this == obj) return true;		
		if(getClass() != obj.getClass()) return false;
		
			// Verifica se atributos do objeto são iguais
		return this.nome.equals(((Pessoa)obj).getNome()) && this.cc == ((Pessoa)obj).getCC() && this.dataNasc.equals(((Pessoa)obj).getDataNasc());
	}
}
