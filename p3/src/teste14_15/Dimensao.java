package teste14_15;

public class Dimensao {
	
	private double comprimento;
	private double largura;
	
	public Dimensao(double comprimento, double largura) {
		assert comprimento > 0 : "Comprimento inválido";
		assert largura > 0 : "Largura inválida";
		
		this.comprimento = comprimento;
		this.largura = largura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public double getLargura() {
		return largura;
	}

	@Override
	public String toString() {
		return "Dimensao [comprimento=" + comprimento + ", largura=" + largura + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(comprimento);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(largura);
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
		Dimensao other = (Dimensao) obj;
		if (Double.doubleToLongBits(comprimento) != Double.doubleToLongBits(other.comprimento))
			return false;
		if (Double.doubleToLongBits(largura) != Double.doubleToLongBits(other.largura))
			return false;
		return true;
	}

}
