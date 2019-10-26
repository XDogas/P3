package aula05.Ex2;

public abstract class Motorizado extends Veiculo {
	
	private Combustivel combustivel;
	private int cilindrada;
	private int potencia;
	private double consumo;
	private double velMax;
	private Matricula matricula;
	
	public Motorizado(int ano, Cor cor, int nrodas, int lotacao, double peso, Combustivel combustivel, int cilindrada, int potencia, double consumo, double velMax, String matricula) {
		super(ano, cor, nrodas, lotacao, peso);
		
		assert cilindrada > 0 : "Cilindrada inválida";
		assert potencia > 0 : "Potencia inválida";
		assert consumo > 0 : "Consumo inválido";
		assert velMax > 0 : "Velocidade máxima inválida";
		
		this.combustivel = combustivel;
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.consumo = consumo;
		this.velMax = velMax;
		this.matricula = new Matricula(matricula);
	}
	
	public Combustivel getCombustivel() { return this.combustivel; }
	public int getCilindrada() { return this.cilindrada; }
	public int getPotencia() { return this.potencia; }
	public double getConsumo() { return this.consumo; }
	public double getVelMax() { return this.velMax; }
	public String matricula() { return this.matricula.toString(); }
	
	public String toString() {
		return super.toString() + "; Combustivel: " + this.getCombustivel()
								+ "; Cilindrada: " + this.getCilindrada()
								+ "; Potencia: " + this.getPotencia()
								+ "; Consumo: " + this.getConsumo()
								+ "; Velocidade Máxima: " + this.getVelMax()
								+ "; Matricula: " + this.matricula();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!super.equals(obj)) return false;
		
		Motorizado other = (Motorizado) obj;
		
		if(this.combustivel == null) {
			if(other.combustivel != null) return false;
		} else if(!this.combustivel.equals(other.matricula)) return false;
		
		if(this.cilindrada != other.cilindrada) return false;
		
		if(this.potencia != other.potencia) return false;
		
		if(this.matricula == null) {
			if(other.matricula != null) return false;
		} else if(!this.matricula.equals(other.matricula)) return false;
		
		return true;
	}

}
