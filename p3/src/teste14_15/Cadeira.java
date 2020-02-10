package teste14_15;

public class Cadeira extends Mobiliario {
	
	private TipoCadeira tipo;
	private int numApoios;
	private double altura;
	
	public enum TipoCadeira {
		Escritorio, Espera, Atendimento;
	}

	public Cadeira(String designacao, int id, Tipo material, TipoCadeira tipo, double altura, int numApoios) {
		super(designacao, id, material);
		
		assert tipo != null : "Tipo de Cadeira inválido";		
		assert altura > 0 : "Altura inválida";
		assert numApoios > 0 : "Número de apoios inválido";
		
		this.tipo = tipo;		
		this.altura = altura;
		this.numApoios = numApoios;
	}

	public TipoCadeira getTipoCadeia() {
		return tipo;
	}

	public int getNumApoios() {
		return numApoios;
	}

	public double getAltura() {
		return altura;
	}

	@Override
	public String toString() {
		return "Cadeira [tipo=" + tipo + ", numApoios=" + numApoios + ", altura=" + altura + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(altura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + numApoios;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadeira other = (Cadeira) obj;
		if (Double.doubleToLongBits(altura) != Double.doubleToLongBits(other.altura))
			return false;
		if (numApoios != other.numApoios)
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}
