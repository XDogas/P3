package aula05.Ex2;

public class Bicicleta extends Veiculo {
	
	public Bicicleta(int ano, Cor cor, int nrodas, int lotacao, double peso) {
		super(ano, cor, nrodas, lotacao, peso);
		assert lotacao <= 4 : "A lotacao de uma bicileta é de 1 a 4";
	}
	
	public String toString() {
		return "Bicicleta: " + super.toString();
	}

}
