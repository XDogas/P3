package aula03.Ex3;

public class PesadoMercadorias extends Veiculo {

	public PesadoMercadorias(int cilindrada, int potencia, int lotacao, char tipoCartaPrecisa, double pesoBruto) {
		super(cilindrada, potencia, lotacao, tipoCartaPrecisa, pesoBruto);
		
		assert lotacao <= 3 : "Lota��o m�xima ultrapassada";
		assert tipoCartaPrecisa == 'C' || tipoCartaPrecisa == 'D' : "Carta inv�lida";
		assert pesoBruto > 3500 : "Peso Bruto m�nimo n�o alcan�ado";
	}
	
	public PesadoMercadorias(PesadoMercadorias pm) {
		this(pm.getCilindrada(), pm.getPotencia(), pm.getLotacao(), pm.getCartaPrecisa(), pm.getPesoBruto());
	}
	
	@Override
	public String toString() {
		return "Pesado de Mercadorias -> " + super.toString();
	}
	
	public boolean canDrive(Condutor c)	{
		return c.getTipoCarta() == 'A' || c.getTipoCarta() == 'B' ? false : true;
	}

}
