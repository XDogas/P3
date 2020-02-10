package teste14_15;

public class Maca extends Marquesa implements Transporte {

	private int numGrades;
	private TipoTransporte transporte;
	
	public Maca(String designacao, int id, Tipo material, double comprimento, double largura, boolean colchao, int numGrades) {
		super(designacao, id, material, comprimento, largura, colchao, false);
		assert numGrades >= 0 : "Número de grades inválido";
		this.numGrades = numGrades;
		this.transporte = TipoTransporte.Urgente;
	}

	public int getNumGrades() {
		return numGrades;
	}

	@Override
	public TipoTransporte getTipo() {
		return transporte;
	}

	@Override
	public void setTipo(TipoTransporte tipo) {
		assert tipo != null : "Tipo de transporte inválido";
		this.transporte = tipo;
	}
	
	@Override
	public String toString() {
		return "Maca [numGrades=" + numGrades + ", transporte=" + transporte + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numGrades;
		result = prime * result + ((transporte == null) ? 0 : transporte.hashCode());
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
		Maca other = (Maca) obj;
		if (numGrades != other.numGrades)
			return false;
		if (transporte != other.transporte)
			return false;
		return true;
	}
	
}
