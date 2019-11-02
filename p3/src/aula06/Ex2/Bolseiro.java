package aula06.Ex2;

public class Bolseiro extends Estudante{
	
	private double bolsa;
	
	public Bolseiro(String nome, int cc, Data dataNasc, Data dataInsc) {
		super(nome, cc, dataNasc, dataInsc);
		
	}
	
	public Bolseiro(String nome, int cc, Data dataNasc) {
		super(nome, cc, dataNasc, Data.hoje());
		
	}
	
	public void setBolsa(double valor) {
		assert valor > 0 : "O valor da bolsa tem de ser positivo";
		this.bolsa = valor;
	}
	
	public double bolsa() { return this.bolsa; }
	
	@Override
	public String toString() {
		 return super.toString() + ", Bolseiro com bolsa de " + bolsa() + " euros";
	}
	
	

}
