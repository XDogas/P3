package aula05.Ex2;

public class Moto extends Motorizado {
	
	public Moto(int ano, Cor cor, int nrodas, int lotacao, double peso, Combustivel combustivel, int cilindrada, int potencia, double consumo, double velMax, String matricula) {
		super(ano, cor, nrodas, lotacao, peso, combustivel, cilindrada, potencia, consumo, velMax, matricula);
	}
	
	public String toString() {
		return "Moto: " + super.toString();
	}

}
