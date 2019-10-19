package aula04.Ex2;

public abstract class Figura {
	
	private Ponto centro;
	
	public Figura(Ponto centro) {
		this.centro = centro;
	}
	
	public Figura(double x, double y) {
		centro = new Ponto(x,y);
	}
	
	public Ponto getCentro() { return this.centro; }
	
	public abstract double area();
	public abstract double perimetro();
	public abstract String toString();

	@Override
	public boolean equals(Object obj) {
			// Testa a class
		if(obj == null) return false;
		if(this == obj) return true;
		if(obj.getClass() != this.getClass()) return false;
			// Verifica se os atributos do objeto são iguais
		Figura other = (Figura) obj;
		if (centro == null)
		{
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		return true;
	}

}
