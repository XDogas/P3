package aula01.Ex3;

public class Circulo {
	
	private double raio;
	private Ponto centro;
	
	public Circulo(double x, double y, double r) {
		centro = new Ponto(x,y);
		raio = r;
	}
	
	public Circulo(Ponto centro, double r) {
		raio = r;
		this.centro = centro;
	}
	
	public double getRaio() { return this.raio; }
	public Ponto getCentro() { return this.centro; }
	
	public double getArea() {
		return Math.PI * Math.pow(raio, 2);
	}
	
	public double getPerimetro() {
		return 2 * Math.PI * raio;
	}
	
	public String toString() {
		return "Circulo:\n-> Centro: " + getCentro() + "\n-> Raio: " + getRaio() + "\n-> �rea: " + getArea() + "\n-> Per�metro: " + getPerimetro();
	}
	
	public boolean equalTo(Circulo c2) {						// Verifica se dois C�rculos s�o iguais
		return this.raio == c2.getRaio();
	}
	
	public boolean intercepts(Circulo c2) {						// Verifica se dois C�rculos se interceptam
		return this.centro.distTo(c2.getCentro()) <= this.raio;	
	}

}
