package aula11.Ex3;

public abstract class Alimento implements Comparable<Alimento> {
	
	private double proteinas;
	private double calorias;
	private double peso;
	
	public Alimento(double proteinas, double calorias, double peso) {
		assert proteinas >= 0 && calorias >= 0 && peso >= 0 : "Alimento inválido";
		
		this.proteinas = proteinas;
		this.calorias = calorias;
		this.peso = peso;
	}
	
	public double getProteinas() { return this.proteinas; }
	public double getCalorias() { return this.calorias; }
	public double getPeso() { return this.peso; }
	
	@Override
	public String toString() {
		return ", Proteínas " + this.getProteinas()
			 + ", calorias " + this.getCalorias()
			 + ", Peso: " + this.getPeso();
	}
	
	public int compareTo(Alimento a) {
		if(this.getCalorias() < a.getCalorias()) return -1;
		if(this.getCalorias() > a.getCalorias()) return 1;
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(proteinas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(proteinas) != Double.doubleToLongBits(other.proteinas))
			return false;
		return true;
	}

}
