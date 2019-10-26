package aula05.Ex2;

public class Automovel extends Motorizado {

	public Automovel(int ano, Cor cor, int nrodas, int lotacao, double peso, Combustivel combustivel, int cilindrada, int potencia, double consumo, double velMax, String matricula) {
		super(ano, cor, nrodas, lotacao, peso, combustivel, cilindrada, potencia, consumo, velMax, matricula);
	}
	
	public String toString() {
		return "Automóvel: " + super.toString();
	}

}
