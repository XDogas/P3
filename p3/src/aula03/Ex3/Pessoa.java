package aula03.Ex3;


public class Pessoa {
	
	private String nome;
	private int cc;
	private Data dataNasc;
	
	public Pessoa(String nome, int cc, Data dataNasc) {
		assert nomeValido(nome) : "Nome inválido";
		assert ccValido(cc) : "cc inválido";
		
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
		 return nome() + "-> BI: " + getCC() + ", Nasc. Data: " + getDataNasc().toString();
	}
}
