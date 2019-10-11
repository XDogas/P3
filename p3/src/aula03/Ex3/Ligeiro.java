package aula03.Ex3;

public class Ligeiro extends Veiculo {

	public Ligeiro(int cilindrada, int potencia, int lotacao, char tipoCartaPrecisa, double pesoBruto) {
		super(cilindrada, potencia, lotacao, tipoCartaPrecisa, pesoBruto);
		
		assert lotacao <= 9 : "Lota��o m�xima ultrapassada";
		assert tipoCartaPrecisa != 'A' : "Carta inv�lida";
		assert pesoBruto <= 3500 : "Peso Bruto m�ximo ultrapassado";
	}
	
	public Ligeiro(Ligeiro l) {
		this(l.getCilindrada(), l.getPotencia(), l.getLotacao(), l.getCartaPrecisa(), l.getPesoBruto());
	}
	
	@Override
	public String toString() {
		return "Ligeiro -> " + super.toString();
	}
	
	public boolean canDrive(Condutor c)	{
		return c.getTipoCarta() == 'A' ? false : true;
	}

}
