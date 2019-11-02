package aula06.Ex1;

public class Carne extends Alimento {
	
	private VariedadeCarne variedade;

	public Carne(VariedadeCarne variedade, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.variedade = variedade;
	}
	
	public VariedadeCarne getVariedade() { return this.variedade; }
	
	@Override
	public String toString() {
		return "Carne " + this.getVariedade() + super.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((variedade == null) ? 0 : variedade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Carne other = (Carne) obj;
		if (variedade != other.variedade)
			return false;
		return true;
	}
	
}
