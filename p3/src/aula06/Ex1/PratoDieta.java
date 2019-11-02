package aula06.Ex1;

public class PratoDieta extends Prato {
	
	private double maxCalorias;

	public PratoDieta(String nome, double maxCalorias) {
		super(nome);
		assert maxCalorias > 0 : "O número de calorias tem de ser positivo";
		this.maxCalorias = maxCalorias;
	}
	
	public double getMaxCalorias() { return this.maxCalorias; }
	
	@Override
	public boolean addIngrediente(Alimento a) {
		if(a == null) return false;
		if(a.getCalorias() + super.getTotalCalorias() > this.maxCalorias) return false;
		return super.addIngrediente(a);
	}
	
	@Override
	public String toString() {
		return "Dieta (" + this.getMaxCalorias() + " Calorias) " + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(maxCalorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		PratoDieta other = (PratoDieta) obj;
		if (Double.doubleToLongBits(maxCalorias) != Double.doubleToLongBits(other.maxCalorias))
			return false;
		return true;
	}

}
