package aula06.Ex1;

public class PratoVegetariano extends Prato {

	public PratoVegetariano(String nome) {
		super(nome);
	}
	
	@Override
	public boolean addIngrediente(Alimento a) {
		if(a == null) return false;
		if(!(a instanceof AlimentoVegetariano)) return false;
		return super.addIngrediente(a);
	}
	
	@Override
	public String toString() {
		return "Vegetariano " + super.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		return true;
	}

}
