package aula03.Ex3;

public class Veiculo {
	
	private int cilindrada;
	private int potencia;
	private int lotacao;
	private char tipoCartaPrecisa;
	private double pesoBruto;
	
	public Veiculo(int cilindrada, int potencia, int lotacao, char tipoCartaPrecisa, double pesoBruto) {
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.lotacao = lotacao;
		this.tipoCartaPrecisa = tipoCartaPrecisa;
		this.pesoBruto = pesoBruto;
	}
	
	public int getCilindrada() { return this.cilindrada; }
	public int getPotencia() { return this.potencia; }
	public int getLotacao() { return this.lotacao; }
	public char getCartaPrecisa() { return this.tipoCartaPrecisa; }
	public double getPesoBruto() { return this.pesoBruto; }
	
	@Override
	public String toString() {
		return "Cilindrada: " + getCilindrada() + ", Pot�ncia: " + getPotencia() + ", Lota��o: " + getLotacao() + ", Tipo de carta precisa: " + getCartaPrecisa() + ", Peso Bruto: " + getPesoBruto();
	}
	
	public boolean equals(Veiculo v) {
		if (v == null) return false;
		return this.cilindrada == v.getCilindrada() && this.potencia == v.getPotencia() && this.lotacao == v.getLotacao() && this.tipoCartaPrecisa == v.getCartaPrecisa() && this.pesoBruto == v.getPesoBruto();
	}

}
