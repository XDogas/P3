package aula04.Ex1;

public class Pessoa {
	
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String nome, int cc, Data dataNasc) {
		assert nomeValido(nome) : "Nome inv�lido";
		assert ccValido(cc) : "cc inv�lido";
		
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
	}
	
	public String nome() { return this.nome; }
	public int getCC() { return this.cc; }
	public Data getDataNasc() { return this.dataNasc; }
	
	public static boolean nomeValido(String nome) {
		return nome.length() > 0;
	}
	
	public static boolean ccValido(int cc) {
		return cc > 0;
	}
	
	@Override
	public String toString() {
		 return nome() + ", BI: " + getCC() + ", Nascido na Data: " + getDataNasc().toString();
	}
	
	@Override
	public boolean equals(Object obj) {
			// Testa a class
		if(obj == null) return false;	
		if(this == obj) return true;		
		if(getClass() != obj.getClass()) return false;
		
			// Verifica se atributos do objeto s�o iguais
		return this.nome.equals(((Pessoa)obj).nome()) && this.cc == ((Pessoa)obj).getCC() && this.dataNasc.equals(((Pessoa)obj).getDataNasc());
	}
}
