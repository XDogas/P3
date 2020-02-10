package aula11.Ex1;

public abstract class Figura implements Comparable<Figura> {
	
	private Ponto centro;
	
	public void setCentro(Ponto centro) {
		this.centro = centro;
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
	
	public int compareTo(Figura f) {
		if(this.area() < f.area()) return -1;
		if(this.area() > f.area()) return 1;
		return 0;
	}

}
