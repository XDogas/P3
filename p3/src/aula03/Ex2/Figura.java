package aula03.Ex2;

public class Figura {
	
	private Ponto centro;
	
	public Figura(Ponto centro) {
		this.centro = centro;
	}
	
	public Figura(double x, double y) {
		centro = new Ponto(x,y);
	}
	
	public Ponto getCentro() { return this.centro; }
	
	@Override
	public String toString() {
		return "tem centro: " + centro.toString() + "\n";
	}

}
