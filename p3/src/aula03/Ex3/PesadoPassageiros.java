package aula03.Ex3;

public class PesadoPassageiros extends Veiculo {
	
	public PesadoPassageiros(int cilindrada, int potencia, int lotacao, char tipoCartaPrecisa, double pesoBruto) {
		super(cilindrada, potencia, lotacao, tipoCartaPrecisa, pesoBruto);
		
		assert lotacao > 9 && lotacao <= 300 : "Lotação inválida"; // o maior autocarro do mundo tem capacidade para 300 passageiros
		assert tipoCartaPrecisa == 'D' : "Carta inválida";
		assert pesoBruto > 3500 : "Peso Bruto mínimo não alcançado";
	}
	
	public PesadoPassageiros(PesadoPassageiros pm) {
		this(pm.getCilindrada(), pm.getPotencia(), pm.getLotacao(), pm.getCartaPrecisa(), pm.getPesoBruto());
	}
	
	@Override
	public String toString() {
		return "Pesado de Passageiros -> " + super.toString();
	}
	
	public boolean canDrive(Condutor c)	{
		return c.getTipoCarta() == 'A' || c.getTipoCarta() == 'B' || c.getTipoCarta() == 'C' ? false : true;
	}

}
