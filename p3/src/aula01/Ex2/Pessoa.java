package aula01.Ex2;

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
	
	public String getNome() { return this.nome; }
	public int getCC() { return this.cc; }
	public Data getDataNasc() { return this.dataNasc; }
	
	public static boolean nomeValido(String nome) {
		return nome.length() > 0;
	}
	
	public static boolean ccValido(int cc) {
		return cc > 0;
	}
	
	public String toString() {
		 return this.nome + " | " + this.cc + " | " + this.dataNasc.toString();
	}
}
