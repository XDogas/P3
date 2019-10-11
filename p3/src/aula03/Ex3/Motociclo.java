package aula03.Ex3;

public class Motociclo extends Veiculo {

	public Motociclo(int cilindrada, int potencia, int lotacao, char tipoCartaPrecisa, double pesoBruto) {
		super(cilindrada, potencia, lotacao, tipoCartaPrecisa, pesoBruto);
		
		assert lotacao <= 2 : "Lota��o m�xima ultrapassada";
		assert pesoBruto <= 750 : "Peso Bruto m�ximo ultrapassado";
		
	}
	
	public Motociclo(Motociclo m) {
		this(m.getCilindrada(), m.getPotencia(), m.getLotacao(), m.getCartaPrecisa(), m.getPesoBruto());
	}
	
	@Override
	public String toString() {
		return "Motociclo -> " + super.toString();
	}
	
	public boolean canDrive(Condutor c)	{
		return true;
	}
		
}
