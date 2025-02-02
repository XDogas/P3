package aula06.Ex1;

public class Peixe extends Alimento {
	
	private TipoPeixe tipo;

	public Peixe(TipoPeixe tipo, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.tipo = tipo;
	}
	
	public TipoPeixe getTipo() { return this.tipo; }
	
	@Override
	public String toString() {
		return "Peixe " + this.getTipo() + super.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Peixe other = (Peixe) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}
